# Android-Y-PhotoPicker
Android library project for selecting/capturing multiple images from the device.

[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[ ![Download](https://api.bintray.com/packages/yongbeam/maven/y-photopicker/images/download.svg) ](https://bintray.com/yongbeam/maven/y-photopicker/_latestVersion)


# Example



# Usage

1.Include the library as local library project.
```gradle
  dependencies {
      compile 'com.yongbeam.y_photopicker:y-photopicker:0.0.1'
  }
```

2.Add PhotoPickerActivity/PhotoPagerActivity/UCropActivity into your AndroidManifest.xml
```xml
    <activity android:name="com.yongbeam.y_photopicker.util.photopicker.PhotoPickerActivity"
        android:theme="@style/Theme.AppCompat.NoActionBar" />

    <activity android:name="com.yongbeam.y_photopicker.util.photopicker.PhotoPagerActivity"
        android:theme="@style/Theme.AppCompat.NoActionBar"/>

    <activity
        android:name="com.yongbeam.y_photopicker.util.photopicker.ucrop.UCropActivity"
        android:theme="@style/Theme.AppCompat.NoActionBar"
        android:screenOrientation="portrait"/>
```


3.Add permission into your AndroidManifest.xml
```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-feature android:name="android.hardware.camera" />
```


4.The Y-PhotoPicker configuration is created using the builder pattern.
```java
      YPhotoPickerIntent intent = new YPhotoPickerIntent(this);
      intent.setMaxSelectCount(20);
      intent.setShowCamera(true);
      intent.setShowGif(true);
      intent.setSelectCheckBox(false);
      intent.setMaxGrideItemCount(3);
      startActivityForResult(intent, REQUEST_CODE);
```

5.Override onActivityResult method and handle Y-PhotoPicker result.
```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<String> photos = null;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            }
        }
    }
```


### Image viewer
```java
    // start image viewr
    Intent startActivity = new Intent(this , PhotoPagerActivity.class);
    startActivity.putStringArrayListExtra("photos" , photos);
    startActivity(startActivity);
```


#### Option
```java
      intent.setMaxSelectCount(20);    
      intent.setShowCamera(true);
      intent.setShowGif(true);
      intent.setSelectCheckBox(false);
      intent.setMaxGrideItemCount(3);
```

##Thanks 
>* [PhotoPicker](https://github.com/donglua/PhotoPicker) 
>* [uCrop](https://github.com/Yalantis/uCrop)


# License

    Copyright 2016 LeeYongBeom

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
