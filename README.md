# react-native-revenue-monster

## Getting started

`$ npm install react-native-revenue-monster --save`

### Mostly automatic installation

`$ react-native link react-native-revenue-monster`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-revenue-monster` and add `RevenueMonster.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRevenueMonster.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.RevenueMonsterPackage;` to the imports at the top of the file
  - Add `new RevenueMonsterPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-revenue-monster'
  	project(':react-native-revenue-monster').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-revenue-monster/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-revenue-monster')
  	```


## Usage
```javascript
import RevenueMonster from 'react-native-revenue-monster';

// TODO: What to do with the module?
RevenueMonster;
```
