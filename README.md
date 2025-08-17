# Fay Take-Home — Android

A small Android app that implements login and an appointments experience using Jetpack Compose, Kotlin, and modern Android tooling

---

## Demo

<!-- <video src="demo/demo.mov" controls width="640"></video> -->

## Notes

App is built using the MVVM Architecture, Single activity, and in general the way the data flows is as follows: UI -> Repository -> Data (Network sources). UI only knows about repository and repository only knows about data.
Throughout the app we're using MaterialTheme for all of the design since doing this will make it easie to make changes to the app down the line (lets say we wanted to change how  MaterialTheme.typography.bodyLarge looked).
Additionally, doing this will also give us Dark mode for free essentially I just needed to come up with a few colors myself which was fun. SVGs have been converted to `ImageVector` as its easier to work with `ImageVector`s.

Some things I couldn't get to:

- Wanted to store jwt token in DataStore but DataStore isn't encrypted so would need to also encrypt before storing
  - The codebase is structured in such a way that will make this easy to integrate. Just need to add libraries and then make the changes inside of `TokenRepository`
  - Additionally, if we do this we'd need a sign out button that will clear this token from the user's phone.
- More modularity. All of the screens (Appointments, Login, Chat, Journal, Profile) should go into their own Feature module. This will help speed up build time.

## Time Breakdown

- Login screen: **2 hours**
- Appointments screen: **4 hours**
- Nice-to-haves: **2 hours** - Loading state, Error state(appointments screen), Figuring out how to convert SVG to ImageVectors 
- Additional time: **2 hours** - Manual Testing, Architecture setup

---
