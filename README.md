# FitLogger - Personal Fitness Activity Tracker

## 📱 Project Overview
FitLogger is an Android application for tracking personal fitness activities. Built as a university exam project demonstrating Android development fundamentals.

## ✨ Features
- ✅ Dashboard with RecyclerView displaying fitness activities
- ✅ Add new activities with name, duration, and date
- ✅ SQLite database for persistent storage
- ✅ Material Design UI components
- ✅ Settings screen
- ✅ Delete activities with confirmation
- ✅ Automatic RecyclerView refresh using lifecycle methods

## 🛠️ Technologies Used
- **Language**: Java
- **IDE**: Android Studio
- **Database**: SQLite (SQLiteOpenHelper)
- **UI**: Material Design Components
- **Architecture**: DAO Pattern
- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34

## 📂 Project Structure
```
com.fitlogger.app/
├── activities/
│   ├── DashboardActivity.java
│   ├── AddActivityActivity.java
│   └── SettingsActivity.java
├── adapters/
│   └── ActivityAdapter.java
├── database/
│   ├── DatabaseHelper.java
│   └── ActivityDAO.java
└── models/
    └── FitnessActivity.java
```

## 🚀 How to Run
1. **Download the project**
   - Click the green "Code" button above
   - Select "Download ZIP"
   - Extract the ZIP file

2. **Open in Android Studio**
   - Open Android Studio
   - File → Open
   - Navigate to extracted folder
   - Select the project root folder

3. **Sync and Build**
   - Wait for Gradle sync to complete
   - Build → Make Project
   - Run on emulator or physical device (API 24+)

## 📊 Database Schema
**Table: activities**
| Column | Type | Description |
|--------|------|-------------|
| id | INTEGER | Primary Key (Auto-increment) |
| activity_name | TEXT | Name of fitness activity |
| duration | TEXT | Duration of activity |
| date | TEXT | Date of activity |

## 🎓 Exam Requirements Met
- ✅ Material Design with Toolbar
- ✅ Options Menu with Settings
- ✅ RecyclerView with CardView items
- ✅ FloatingActionButton for adding activities
- ✅ SQLite database (NOT Room)
- ✅ DatabaseHelper class
- ✅ ActivityDAO class with CRUD operations
- ✅ Proper lifecycle handling (onResume)
- ✅ Input validation
- ✅ Clean, commented code

## 📐 UML Activity Diagram

```
                        [START]
                           │
                           ▼
                  ┌─────────────────┐
                  │  Launch App     │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │ Dashboard       │
                  │ Activity        │
                  └────────┬────────┘
                           │
                ┌──────────┼──────────┐
                │          │          │
                ▼          ▼          ▼
         ┌──────────┐ ┌────────┐ ┌──────────┐
         │View      │ │Click   │ │Click     │
         │Activities│ │FAB     │ │Settings  │
         └──────────┘ └───┬────┘ └────┬─────┘
                          │           │
                          ▼           ▼
                  ┌─────────────┐ ┌──────────┐
                  │Add Activity │ │Settings  │
                  │Screen       │ │Screen    │
                  └──────┬──────┘ └────┬─────┘
                         │             │
                         ▼             │
                  ┌─────────────┐     │
                  │Enter Details│     │
                  │& Save       │     │
                  └──────┬──────┘     │
                         │             │
                         ▼             │
                  ┌─────────────┐     │
                  │Save to DB   │     │
                  │(via DAO)    │     │
                  └──────┬──────┘     │
                         │             │
                         └─────┬───────┘
                               │
                               ▼
                        ┌──────────────┐
                        │onResume()    │
                        │Refresh List  │
                        └──────────────┘
                               │
                               ▼
                          [END]
```

## 🔑 Key Concepts

### Why SQLite Instead of Room?
- Demonstrates understanding of low-level database operations
- Shows knowledge of SQL, Cursor, ContentValues
- Room is a higher-level abstraction; SQLite shows foundational knowledge

### Why DAO Pattern?
- **Separation of Concerns**: Business logic separated from database operations
- **Maintainability**: Easy to modify database operations without touching UI
- **Testability**: DAO can be tested independently
- **Best Practice**: Industry-standard design pattern

### Why onResume() for RecyclerView Refresh?
```
Activity Lifecycle:
onCreate() → onStart() → onResume() → [Activity Running]

When user returns from AddActivityActivity:
onRestart() → onStart() → onResume()

onCreate() is NOT called again!
onResume() is ALWAYS called when activity becomes visible
Therefore, we refresh data in onResume()
```

## 👨‍💻 Author
**RANA MUHAMMAD AWAIS**
- Email: rana.16241.ac@iqra.edu.pk
- University Exam Project

## 📄 License
This project is created for educational purposes.

---

## 📥 Download Instructions
1. Click the green **"Code"** button at the top of this page
2. Select **"Download ZIP"**
3. Extract the ZIP file to your desired location
4. Open the project in Android Studio
5. Wait for Gradle sync
6. Build and run!

**Repository URL**: https://github.com/rana16241-ac/FitLogger-Android-App
