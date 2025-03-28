E-Commerce - MVVM + Hilt + Retrofit + Coroutines

A simple Android application demonstrating Dependency Injection (DI) using Hilt, MVVM architecture, and Coroutines with Retrofit to fetch and display products from FakeStore API.

🚀 Features

Fetch product data using Retrofit

Use MVVM architecture to separate concerns

Implement Hilt for Dependency Injection

Manage API calls efficiently using Coroutines & Flows

Display fetched products in a RecyclerView

🏗️ Tech Stack

Kotlin

MVVM Architecture

Hilt (Dependency Injection)

Retrofit (Networking)

Coroutines & Flow (Async Programming)

LiveData & StateFlow (State Management)

📦 API Response Format

This app fetches data from FakeStore API, which returns JSON like this:

[
  {
    "id": 1,
    "title": "Fjallraven Backpack",
    "price": 109.95,
    "description": "Your perfect pack for everyday use...",
    "category": "men's clothing",
    "image": "https://example.com/image.jpg",
    "rating": { "rate": 3.9, "count": 120 }
  }
]

📌 Project Setup

1️⃣ Clone the Repository

git clone https://github.com/saurabhkharade/E-CommerceApp/


2️⃣ Add Dependencies

Ensure you have the following dependencies in build.gradle:

// Retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// Hilt
implementation "com.google.dagger:hilt-android:2.42"
kapt "com.google.dagger:hilt-compiler:2.42"

// Coroutines
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"

3️⃣ Enable Hilt in Application Class

@HiltAndroidApp
class StoreManageApp : Application()

📂 Project Structure
![Screenshot 2025-03-28 232452](https://github.com/user-attachments/assets/7d6e7a19-0716-485f-ae27-53139a0d767c)



🔥 Implementation Details

1️⃣ Define API Interface (NetworkServices.kt)

2️⃣ Create Repository (ProductRepository.kt)

3️⃣ ViewModel (ProductListViewModel.kt)

📱 UI Implementation (RecyclerView Adapter)

🎯Thank You 🚀
