# CakeAPI Addon Startup Template
Provided a quick approach to create addon from CakeAPI.

## Usage
1. Fork this project into your GitHub account.
2. Setting up `~/.gradle/gradle.perproties` with field `llmc.usr` and `llmc.key`. 
   You can generate your Personal Access Token at [https://github.com/settings/tokens](https://github.com/settings/tokens).
   `llmc.usr` could be your email or GitHub username.
2. Editing following files:
    - `settings.gradle.kts`
      Change `rootProject.name` to your addon name
    - `build.gradle.kts`
      Change `group` to your domain       
3. Create package `domain.your.xxx` and create **Main Cass** named as same as `rootProject.name` you set before.
4. Making **Main Class** inherits from `CakeAddon`.
