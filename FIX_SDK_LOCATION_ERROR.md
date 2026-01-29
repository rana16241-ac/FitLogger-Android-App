# Fix SDK Location Error

## ❌ Error Message
```
SDK location not found. Define a valid SDK location with an ANDROID_HOME 
environment variable or by setting the sdk.dir path in your project's 
local properties file at 'C:\Users\lab-1\Downloads\FitLogger-Android-App-main\local.properties'.
```

## ✅ Solution - Step by Step

This error happens because Android Studio doesn't know where your Android SDK is installed. Here's how to fix it:

---

## 🚀 **EASIEST FIX - Let Android Studio Auto-Configure**

### **Step 1: Close the Error Dialog**
1. If you see an error popup, click **"OK"** or close it

### **Step 2: Open Project Structure**
1. In Android Studio, click **File → Project Structure**
2. OR press **Ctrl+Alt+Shift+S** (Windows) or **Cmd+;** (Mac)

### **Step 3: Set SDK Location**
1. In the left panel, click **"SDK Location"**
2. Look for **"Android SDK location"** field
3. Click the **folder icon** (📁) next to it
4. Navigate to your Android SDK folder (usually):
   - **Windows**: `C:\Users\YourUsername\AppData\Local\Android\Sdk`
   - **Mac**: `/Users/YourUsername/Library/Android/sdk`
   - **Linux**: `/home/YourUsername/Android/Sdk`
5. Click **"OK"**
6. Click **"Apply"** then **"OK"**

### **Step 4: Sync Gradle**
1. Click **File → Sync Project with Gradle Files**
2. Wait for sync to complete
3. Error should be GONE! ✅

---

## 📝 **ALTERNATIVE FIX - Create local.properties File Manually**

### **Step 1: Find Your Android SDK Path**

#### **On Windows:**
1. Open File Explorer
2. Go to: `C:\Users\YourUsername\AppData\Local\Android\Sdk`
3. If you can't see `AppData`, enable hidden folders:
   - Click **View** tab
   - Check **"Hidden items"**
4. Copy this path

**Common Windows SDK paths:**
```
C:\Users\YourUsername\AppData\Local\Android\Sdk
C:\Android\Sdk
C:\Program Files\Android\Android Studio\sdk
```

#### **On Mac:**
1. Open Finder
2. Press **Cmd+Shift+G**
3. Type: `/Users/YourUsername/Library/Android/sdk`
4. Press Enter
5. Copy this path

#### **On Linux:**
```
/home/YourUsername/Android/Sdk
```

### **Step 2: Create local.properties File**

1. In Android Studio, switch to **Project** view (top-left dropdown)
2. Right-click on **FitLogger-Android-App** (root folder)
3. Select **New → File**
4. Type: `local.properties`
5. Press Enter

### **Step 3: Add SDK Path**

**For Windows**, add this line (replace with YOUR path):
```properties
sdk.dir=C\:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk
```

**IMPORTANT for Windows**: Use double backslashes `\\` or forward slashes `/`

**Examples:**
```properties
# Option 1: Double backslashes
sdk.dir=C\:\\Users\\lab-1\\AppData\\Local\\Android\\Sdk

# Option 2: Forward slashes (easier)
sdk.dir=C:/Users/lab-1/AppData/Local/Android/Sdk
```

**For Mac:**
```properties
sdk.dir=/Users/YourUsername/Library/Android/sdk
```

**For Linux:**
```properties
sdk.dir=/home/YourUsername/Android/Sdk
```

### **Step 4: Save and Sync**
1. Press **Ctrl+S** to save
2. Click **File → Sync Project with Gradle Files**
3. Wait for sync to complete

---

## 🔍 **How to Find Your SDK Path in Android Studio**

### **Method 1: Check Android Studio Settings**
1. Click **File → Settings** (Windows/Linux) or **Android Studio → Preferences** (Mac)
2. Go to **Appearance & Behavior → System Settings → Android SDK**
3. Look at the top - you'll see **"Android SDK Location"**
4. Copy this path

### **Method 2: Check Welcome Screen**
1. Close your project (File → Close Project)
2. On the welcome screen, click **More Actions → SDK Manager**
3. Look at the top for **"Android SDK Location"**
4. Copy this path

---

## 📂 **File Location**

The `local.properties` file should be in the **ROOT** folder:

```
FitLogger-Android-App/
├── local.properties  ← HERE! (Same level as gradle.properties)
├── gradle.properties
├── settings.gradle
├── build.gradle
├── app/
└── ...
```

---

## ⚠️ **Important Notes**

### **About local.properties:**
- ✅ This file is **machine-specific** (different for each computer)
- ✅ It's automatically created by Android Studio
- ✅ It's in `.gitignore` (not uploaded to GitHub)
- ✅ You need to create it on each new computer

### **Why it's not in GitHub:**
- Each developer has Android SDK in different locations
- The file contains your local computer paths
- It's automatically generated when you open the project

---

## 🎯 **Quick Fix for Your Specific Error**

Based on your error message, create `local.properties` with:

```properties
sdk.dir=C:/Users/lab-1/AppData/Local/Android/Sdk
```

**Steps:**
1. Create file named `local.properties` in project root
2. Add the line above (or your actual SDK path)
3. Save the file
4. Sync Gradle
5. Done! ✅

---

## 🚨 **If SDK is Not Installed**

If you can't find the SDK folder, you need to install it:

### **Step 1: Open SDK Manager**
1. In Android Studio, click **Tools → SDK Manager**
2. OR click the SDK icon in the toolbar

### **Step 2: Install SDK**
1. Check **"Android SDK Platform"** for API 34
2. Check **"Android SDK Build-Tools"**
3. Click **"Apply"**
4. Wait for download and installation
5. Click **"OK"**

### **Step 3: Note the SDK Location**
1. Look at the top of SDK Manager
2. Copy the **"Android SDK Location"** path
3. Use this path in `local.properties`

---

## ✅ **Verify the Fix**

After applying the fix:

1. ✅ No SDK location error
2. ✅ Gradle sync successful
3. ✅ "BUILD SUCCESSFUL" message
4. ✅ Can run the app

---

## 🔧 **Complete Fix Checklist**

- [ ] Found Android SDK location on your computer
- [ ] Created `local.properties` file in project root
- [ ] Added `sdk.dir=` line with correct path
- [ ] Used correct path format (double backslashes or forward slashes)
- [ ] Saved the file
- [ ] Synced Gradle
- [ ] No errors in Build tab
- [ ] App builds successfully

---

## 📋 **Example local.properties File**

**Windows Example:**
```properties
## This file must *NOT* be checked into Version Control Systems,
# as it contains information specific to your local configuration.
#
# Location of the SDK. This is only used by Gradle.
# For customization when using a Version Control System, please read the
# header note.
sdk.dir=C:/Users/lab-1/AppData/Local/Android/Sdk
```

**Mac Example:**
```properties
sdk.dir=/Users/awais/Library/Android/sdk
```

**Linux Example:**
```properties
sdk.dir=/home/awais/Android/Sdk
```

---

## 🎉 **Success!**

After creating `local.properties` with the correct SDK path:

1. Gradle will sync successfully
2. Project will build without errors
3. You can run the app on emulator/device

---

## 📞 **Still Having Issues?**

### **Problem: Can't find SDK folder**
**Solution**: Install Android SDK through SDK Manager (Tools → SDK Manager)

### **Problem: Path is correct but still error**
**Solution**: 
1. Make sure you're using forward slashes `/` or double backslashes `\\`
2. No spaces at the beginning or end of the line
3. File is named exactly `local.properties` (no .txt extension)

### **Problem: File won't save**
**Solution**: 
1. Close Android Studio
2. Create the file manually in Notepad/TextEdit
3. Save it in the project root folder
4. Reopen Android Studio

---

## 🎯 **Quick Summary**

**The Problem**: Android Studio doesn't know where your Android SDK is located

**The Solution**: Create `local.properties` file with your SDK path

**Format**: `sdk.dir=C:/Users/YourUsername/AppData/Local/Android/Sdk`

**Location**: Project root folder (same level as build.gradle)

---

**Last Updated**: January 29, 2026  
**Status**: ✅ Solution Provided
