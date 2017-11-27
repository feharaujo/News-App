# News App
Android implementation of the News Api (https://newsapi.org)

## Prerequisites
Android Studio 3.0.1

## Configuration
- Get your API Key at https://newsapi.org
- Open the project file gradle.properties and replace your key in the api_key attribute
api_key = "YOUR_KEY"

## Layers
The project has three layers
- UI: Activity, fragment, ViewModel, adapter
- Data: Local repository and Remote repository
- Model: Model's mapping

## Tools and frameworks
- Kotlin
- Anko (with experimental enabled to use @Parcelize annotation)
- Architecture Components
- Dagger 2 (with Android module)
- Support Libraries
- Constraint Layout
- Data Binding
- Picasso
- Retrofit 2
- Gson
- Realm

## Approach
- All the layers make use of dependency injection to provide all your dependencies, using the Dagger 2 framework.
- The UI layer makes use of the MVVM pattern to communicate between View and ViewModel.
- The UI makes use of the Architecture Components library to be lifecycle-aware.
- The View make use of Data binding to control your states linked in the ViewModel (by observables), making possible a reactive approach to view communication.
- The Data layer makes use of the Repository pattern to control the remote and local data.
- When the app receives data from the remote API, the local realm database is updated, making possible use the app offline.
- The main Repository class receives the Remote and Local implementation by dependency injection.
- The Data layer is injected as a Singleton, so all the views share the same instance (and not recreated).
- The repository makes use of LiveData (an Observable) to send the data to the view.
- The model makes use of Anko library to generate the Parcelable boilerplate, using the @Parcelize annotation.
