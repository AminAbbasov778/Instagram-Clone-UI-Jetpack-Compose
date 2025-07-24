# 📸 Instagram Home Screen Clone UI (Jetpack Compose)

**Instagram Clone UI** is a modern, Kotlin-based Android application that replicates Instagram’s home screen design using **Jetpack Compose**. The project focuses entirely on building a smooth, responsive, and highly customizable UI experience, implementing **Compose best practices**, **custom indicators**, and **dynamic layouts**.  
This project does not include backend functionality or real user data—it's intended for **UI prototyping**, **portfolio showcase**, and **learning purposes**.

---

## 📸 Screenshots

| Header & Stories | Post Slider | Bottom Navigation | Profile Indicator |
|------------------|-------------|-------------------|-------------------|
| <img src="screenshots/header.png" width="200" height="400" /> | <img src="screenshots/slider.png" width="200" height="400" /> | <img src="screenshots/bottomnav.png" width="200" height="400" /> | <img src="screenshots/profilehighlight.png" width="200" height="400" /> |

> *(Make sure to include your actual screenshots in the `/screenshots` folder.)*

---

## 🧱 Key Features

* ✨ Instagram-style **Header**
* 🔁 Fully scrollable **Stories Section** with self + others
* 🎞️ **Horizontal Image Slider** with overlay UI (page count, icon)
* 📍 **Custom Pager Indicator** with adaptive dot sizing
* 🧭 Modern **Bottom Navigation Bar** with profile highlight and red dot
* 🗂️ **Post Layout** with user, image, like/comment/share buttons
* 🎨 Clean Material3 Compose styling

---

## 🚀 Built With

| Technology               | Purpose                                  |
|--------------------------|------------------------------------------|
| **Kotlin**               | Primary language                         |
| **Jetpack Compose**      | Declarative UI Toolkit                   |
| **Material3**            | Modern UI Components                     |
| **Accompanist Pager**    | ViewPager replacement in Compose         |
| **State & Effects API**  | Compose `remember`, `mutableStateOf`     |
| **Composable Functions** | Reusable, lifecycle-aware UI blocks      |
| **Android Studio**       | IDE for development                      |

---

## 🎨 UI Components

### 📌 InstagramHeader
- Title + ExpandMore icon
- Favorite, Message, Add icons aligned right

### 📌 StoriesSection
- LazyRow with circular stories
- First item includes “+” for "Your Story"
- Other items show profile + background ring

### 📌 PostItem
- Profile info, username, and slider
- HorizontalPager for image preview
- Bottom sheet overlay with CTA and like/comment/share/bookmark bar

### 📌 BottomNavigationBar
- NavigationBar with 5 items:
  - Home
  - Search
  - Reels
  - Shop
  - Profile (with red notification dot)

### 📌 ImageSlider
- Compose Accompanist HorizontalPager
- Includes:
  - Top-right page indicator (e.g., `1/5`)
  - Bottom-left profile icon overlay
  - Bottom CTA bar
  - Dynamic dot indicators

---

## 🧠 Architecture Overview

While this is a **UI-only app**, the code still adheres to composable and scalable principles.

### 🔹 Stateless Composables
- UI broken into small composable units for reusability
- All `@Composable` functions are self-contained and previewable

### 🔹 State Management
- Uses `remember` and `mutableStateOf`
- Supports recomposition on user interactions

### 🔹 Clean Code Practices
- Proper naming conventions
- Use of `Modifier` chaining
- Style separation via themes and color resources

---

## 🧩 Project Structure

- `MainActivity.kt` – App entry point
- `HomeScreen()` – Composable home layout
- `InstagramHeader()` – Top app bar with logo and icons
- `StoriesSection()` – Horizontal scrollable stories
- `PostItem()` – Post UI with slider and details
- `ImageSlider()` – HorizontalPager with CTA & indicators
- `BottomNavigationBar()` – Bottom navigation with profile status
- `CustomPagerIndicator()` – Animated dots for slider
- `StoryModel.kt` – Data class for stories
- `res/drawable` – All image assets
- `ui.theme` – Color, typography, theme setup


