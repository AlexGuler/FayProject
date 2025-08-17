package com.example.fayproject.repository

import javax.inject.Inject

interface TokenRepository {
    var token: String?
}

class TokenRepositoryImpl @Inject constructor() : TokenRepository {

    override var token: String? = null

}
