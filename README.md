E-Commerce - MVVM + Dagger + Retrofit + Coroutines

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

Dagger (Dependency Injection)

Retrofit (Networking)

Coroutines & Flow (Async Programming)

LiveData & StateFlow (State Management)

📦 API Response Format

This app fetches data from FakeStore API, which returns JSON like this:

[
  {
        "id": 1,
        "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
        "price": 109.95,
        "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        "category": "men's clothing",
        "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        "rating": {
            "rate": 3.9,
            "count": 120
        }
    },
    {
        "id": 2,
        "title": "Mens Casual Premium Slim Fit T-Shirts ",
        "price": 22.3,
        "description": "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
        "category": "men's clothing",
        "image": "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
        "rating": {
            "rate": 4.1,
            "count": 259
        }
    }
]

📌 Project Setup

1️⃣ Clone the Repository

git clone https://github.com/saurabhkharade/E-CommerceApp/


2️⃣ Add Dependencies

Ensure you have the following dependencies in build.gradle:
 implementation( "androidx.recyclerview:recyclerview:1.3.2")

    // Image loading (Glide)
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    kapt ("com.github.bumptech.glide:compiler:4.16.0")


    // Networking (Retrofit)
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Lifecycle components
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Dependency Injection (Dagger)
    implementation (libs.dagger)
    kapt(libs.dagger.compiler)
    
    lifecycleViewmodelKtx = "2.8.7"
    androidx-lifecycle-viewmodel-ktx = { module = "androidx.lifecycle:lifecycle-viewmodel-ktx", version.ref = "lifecycleViewmodelKtx" }


    dagger = "2.50"
    // Dependency Injection (Dagger)
    implementation (libs.dagger)
    kapt(libs.dagger.compiler)


3️⃣ Enable Hilt in Application Class


📂 Project Structure
![Screenshot 2025-03-28 232452](https://github.com/user-attachments/assets/7d6e7a19-0716-485f-ae27-53139a0d767c)


🔥 Implementation Details

1️⃣ Define API Interface (NetworkServices.kt)

2️⃣ Create Repository (ProductRepository.kt)

3️⃣ ViewModel (ProductListViewModel.kt)

📱 UI Implementation (RecyclerView Adapter)

🎯Thank You 🚀
