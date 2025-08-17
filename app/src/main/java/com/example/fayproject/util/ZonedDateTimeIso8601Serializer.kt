package com.example.fayproject.util

import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

object ZonedDateTimeIso8601Serializer : KSerializer<ZonedDateTime> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ZonedDateTime", PrimitiveKind.STRING)

    private val zonedFmt = DateTimeFormatter.ISO_ZONED_DATE_TIME
    private val offsetFmt = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    override fun deserialize(decoder: Decoder): ZonedDateTime {
        val text = decoder.decodeString()
        return try {
            ZonedDateTime.parse(text, zonedFmt)
        } catch (_: DateTimeParseException) {
            try {
                OffsetDateTime.parse(text, offsetFmt).toZonedDateTime()
            } catch (_: DateTimeParseException) {
                Instant.parse(text).atZone(ZoneOffset.UTC)
            }
        }
    }

    override fun serialize(encoder: Encoder, value: ZonedDateTime) {
        encoder.encodeString(value.format(offsetFmt))
    }
}
