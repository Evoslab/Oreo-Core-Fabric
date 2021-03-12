# Introduction to Cookie Core

Welcome to Cookie Core wiki!

## Installation & Dependencies

* To install it you must put Cookie Core Dependancie in your _build.gradle_
* _You also have to install ARRP which is basically datagen and  Cookie Core **requires** this \(also in your build.gradle\)_

```text
dependencies {
	//ARRP
	modImplementation group: 'net.devtech', name: 'arrp', version: '0.3.7'
	//Cookie Core
	modImplementation group: 'com.github.evoslab', name: 'cookiecore', version: '0.0.2'
}

repositories {
	//ARRP Maven
	maven {
		url = 'https://raw.githubusercontent.com/Devan-Kerman/Devan-Repo/master/'
	}
	//Cookie Core Maven
	maven {
		url = 'https://raw.githubusercontent.com/Evoslab/Evoslab-Maven-Repo/master/'
	}
}
```

## 

