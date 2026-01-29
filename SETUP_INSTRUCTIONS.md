# FitLogger - Setup Instructions

## 📥 How to Download and Run

### Method 1: Download ZIP File (Recommended for Exam Submission)

1. **Download the Project**
   - Go to: https://github.com/rana16241-ac/FitLogger-Android-App
   - Click the green **"Code"** button
   - Select **"Download ZIP"**
   - Save the ZIP file to your computer

2. **Extract the ZIP File**
   - Right-click the downloaded ZIP file
   - Select "Extract All" or "Extract Here"
   - Choose a location on your computer

3. **Open in Android Studio**
   - Launch Android Studio
   - Click **"Open"** (or File → Open)
   - Navigate to the extracted folder
   - Select the **FitLogger-Android-App** folder
   - Click **"OK"**

4. **Wait for Gradle Sync**
   - Android Studio will automatically sync Gradle
   - This may take 2-5 minutes on first open
   - Wait for "Gradle sync finished" message

5. **Build the Project**
   - Click **Build → Make Project** (or press Ctrl+F9)
   - Wait for build to complete
   - Check for any errors in the Build tab

6. **Run the Application**
   - Connect an Android device (API 24+) OR start an emulator
   - Click the **Run** button (green play icon)
   - Select your device/emulator
   - Wait for app to install and launch

---

### Method 2: Clone with Git

```bash
git clone https://github.com/rana16241-ac/FitLogger-Android-App.git
cd FitLogger-Android-App
```

Then follow steps 3-6 from Method 1.

---

## 🔧 System Requirements

### Android Studio Requirements:
- **Android Studio**: Arctic Fox or newer (2020.3.1+)
- **Gradle**: 8.2.0 (included in project)
- **JDK**: Java 8 or higher
- **RAM**: Minimum 8GB recommended
- **Disk Space**: 4GB free space

### Android Device/Emulator Requirements:
- **Minimum SDK**: API 24 (Android 7.0 Nougat)
- **Target SDK**: API 34 (Android 14)
- **Recommended**: API 30+ for best experience

---

## 📱 Testing the Application

### Test Scenario 1: Add Activity
1. Launch the app
2. Click the **+** (FAB) button
3. Enter activity name: "Running"
4. Enter duration: "30 minutes"
5. Select a date
6. Click **Save Activity**
7. Verify you return to dashboard
8. Verify new activity appears in the list

### Test Scenario 2: View Activities
1. Dashboard should show all saved activities
2. Each card should display:
   - Activity name
   - Duration
   - Date
   - Delete button

### Test Scenario 3: Delete Activity
1. Click the red delete icon on any activity
2. Confirm deletion in dialog
3. Verify activity is removed from list

### Test Scenario 4: Settings
1. Click the 3-dot menu (top-right)
2. Select "Settings"
3. Verify settings screen opens
4. Press back button to return

### Test Scenario 5: Lifecycle (IMPORTANT FOR EXAM)
1. Add an activity
2. Observe that dashboard automatically refreshes
3. This demonstrates **onResume()** lifecycle method

---

## 🐛 Troubleshooting

### Problem: Gradle Sync Failed
**Solution:**
- File → Invalidate Caches → Invalidate and Restart
- Check internet connection
- Update Android Studio to latest version

### Problem: Build Errors
**Solution:**
- Build → Clean Project
- Build → Rebuild Project
- Check that all dependencies are downloaded

### Problem: App Crashes on Launch
**Solution:**
- Check LogCat for error messages
- Verify device/emulator meets minimum SDK requirement (API 24)
- Uninstall and reinstall the app

### Problem: RecyclerView Not Showing Activities
**Solution:**
- Check database is created (use Device File Explorer)
- Verify activities are being saved (check LogCat)
- Try adding a new activity

---

## 📂 Project Structure Verification

After opening in Android Studio, verify these folders exist:

```
FitLogger-Android-App/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/fitlogger/app/
│   │   │   │   ├── activities/
│   │   │   │   │   ├── DashboardActivity.java ✓
│   │   │   │   │   ├── AddActivityActivity.java ✓
│   │   │   │   │   └── SettingsActivity.java ✓
│   │   │   │   ├── adapters/
│   │   │   │   │   └── ActivityAdapter.java ✓
│   │   │   │   ├── database/
│   │   │   │   │   ├── DatabaseHelper.java ✓
│   │   │   │   │   └── ActivityDAO.java ✓
│   │   │   │   └── models/
│   │   │   │       └── FitnessActivity.java ✓
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_dashboard.xml ✓
│   │   │   │   │   ├── activity_add_activity.xml ✓
│   │   │   │   │   ├── activity_settings.xml ✓
│   │   │   │   │   └── item_activity.xml ✓
│   │   │   │   ├── menu/
│   │   │   │   │   └── dashboard_menu.xml ✓
│   │   │   │   └── values/
│   │   │   │       ├── strings.xml ✓
│   │   │   │       ├── colors.xml ✓
│   │   │   │       └── themes.xml ✓
│   │   │   └── AndroidManifest.xml ✓
│   │   └── build.gradle ✓
│   └── proguard-rules.pro ✓
├── build.gradle ✓
├── settings.gradle ✓
└── README.md ✓
```

---

## 🎓 Exam Submission Checklist

Before submitting, verify:

- ✅ All Java files compile without errors
- ✅ All XML layouts are properly formatted
- ✅ App runs on emulator/device
- ✅ Can add activities successfully
- ✅ RecyclerView displays activities
- ✅ Delete functionality works
- ✅ Settings screen accessible
- ✅ Material Design implemented
- ✅ SQLite database (NOT Room)
- ✅ DAO pattern implemented
- ✅ Lifecycle methods documented
- ✅ Code is well-commented

---

## 📞 Support

If you encounter any issues:

1. Check the **Troubleshooting** section above
2. Review the **README.md** for project documentation
3. Check Android Studio's **LogCat** for error messages
4. Verify all files are present in the project structure

---

## 🎯 Key Features to Demonstrate in Exam

1. **Material Design**
   - Show Toolbar with app title
   - Demonstrate FAB button
   - Show CardView items in RecyclerView

2. **Database Operations**
   - Explain DatabaseHelper class
   - Demonstrate DAO methods
   - Show data persistence (close and reopen app)

3. **Lifecycle Management**
   - Explain why onResume() is used
   - Demonstrate automatic refresh when returning from AddActivity

4. **Input Validation**
   - Try to save empty activity name
   - Show error messages

5. **Navigation**
   - Dashboard → Add Activity → Dashboard
   - Dashboard → Settings → Dashboard
   - Show back button functionality

---

## 📄 License

This project is created for educational purposes as a university exam submission.

**Author**: RANA MUHAMMAD AWAIS  
**Email**: rana.16241.ac@iqra.edu.pk  
**Repository**: https://github.com/rana16241-ac/FitLogger-Android-App
