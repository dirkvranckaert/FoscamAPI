# FoscamAPI
Easily connect to Foscam IP cameras with this lightweight Java library. One command is all it takes.  
FoscamAPI is suitable for all the IP cameras, including but not limited to FI9821W, FI9818W, FI9801W, FI9802W, FI9805W, FI9900P and FosBaby P1.  
It is tested on the FI9900P.  
More details are on [the pages](https://hypothermic.github.io/FoscamAPI/).

## Example
```java
// Connect to the camera
Foscam camera = new Foscam("192.168.1.40", 88, "username", "password");

// Do whatever you want
camera.setSharpness(90);
...
```

## Maven dependency
```xml
<repository>
  <id>foscamlib-mvn-repo</id>
  <url>https://raw.github.com/hypothermic/foscamapi/mvn-repo/</url>
</repository>

<dependency>
  <groupId>nl.hypothermic</groupId>
  <artifactId>foscamlib</artifactId>
  <!-- If you're using Maven3, specify version tag -->
  <version>LATEST</version>
</dependency>
```

## Gradle dependency
```gradle
repositories {
    maven {
        url "https://raw.github.com/hypothermic/foscamapi/mvn-repo/"
    }
}

dependencies {
    // Note: use 'api' instead of 'compile' if you're using Android Studio.
    compile group: 'nl.hypothermic', name: 'foscamlib', version: '1.08-RELEASE'
}
```

## Features
Here is a full list of commands:

```java
// Image settings
- getBrightness();
- setBrightness(0-100);
- getContrast();
- setContrast(0-100);
- getSaturation();
- setSaturation(0-100);
- getSharpness();
- setSharpness(0-100);
- resetImageSetting();

// Image manipulation
- isMirrored();
- isFlipped();
- setMirrored(true/false);
- setFlipped(true/false);

// Networking
- isDHCP();
- getIP();
- getNetworkGateway();
- getNetworkMask();
- getNetworkDNSPrimary();
- getNetworkDNSSecondary();
- getURL();
- getInterfaceURL();

- getIPConfig();
- setIPConfig();

- getPortInfo();
    - getWebPort();
    - getMediaPort();
    - getHttpsPort();
    - getOnvifPort();
    - getRtspPort();
- setPortInfo(PortInfo);

- isUPnPEnabled();
- setUPNP(true/false);

- isP2PEnabled();
- setP2P(true/false);
- getP2PPort();
- setP2PPort(value);

- getFTPConfig();
- setFTPConfig(FTPConfig);

- isWifiEnabled();
- isWifiConnected();
- getWifiApSSID();
- getWifiApKey();
- getWifiList();
- getWifiListWithIndexes();
- getWifiConfig();
- setWifiConfig();

- isFirewallEnabled();
- getFirewallRule();
- getFirewallEntry(0-7);

// Camera controls
- snapPicture();
- openInfraLed();
- closeInfraLed();
- getInfraLedMode();
- setInfraLedMode(0-1);
- rebootSystem();
- exportConfig();
- exportedConfigURL();
- getLogEntries(count, offset);

// Camera info
- getName();
- setName("MyCamera");
- getSystemTime();
- setSystemTime(...);
- getProductAppVer();
- getProductModel();
- getProductModelName();
- getProductLanguage();
- getProductSensorType();
- getProductWifiType();
- set485Info(...);
- get485Info();

- isAudioSupported();
- isIoAlarmSupported();
- isOnvifSupported();
- isP2PSupported();
- isSdcardSupport();
- isProductOutdoorModel();
- isProductZoomModel();
- isPtModel();
- isRs485Supported();
- isRtspSupported();
- isTalkSupported();
- isWPSSupported();

// Camera streams
- getMainVideoStreamType();
- getSubVideoStreamType();
- getH264FrameRefMode()
- setMainVideoStreamType(0-3);
- setSubStreamFormat(0-1);
- setH264FrameRefMode(0-1)
- getScheduleRecordStreamChn();
- setScheduleRecordStreamChn(...);
- reloadRecordIndex();
- getMJStreamURL();

- setSnapConfig();
- getSnapConfig();

- getSaveLocation();
- setSaveLocation();
- getFreeStorageCapacity();
- getTotalStorageCapacity();

// Account control
- addAccount(...);
- deleteAccount(...);
- changePassword(...);
- changeUsername(...);
- getUserPrivilege();
- getUserList();
- getUserListWithIndexes();
- getSessionList();
- getSessionListWithIndexes();

// OSD settings
- getOSDSettings();
- setOSDSettings(...);
- isOSDMaskEnabled();
- setOSDMaskState(true/false);

// Alarm settings
- getMotionDetectConfig();
- setMotionDetectConfig(...);
- getLocalAlarmRecordConfig();
- setLocalAlarmRecordConfig(...);

// Audio controls (not supported by 3518A based cameras)
- getAudioVolume();
- setAudioVolume();

// PTZ controls
- ptzMoveUp();
- ptzMoveDown();
- ptzMoveLeft();
- ptzMoveRight();
- ptzMoveTopLeft();
- ptzMoveTopRight();
- ptzMoveBottomLeft();
- ptzMoveBottomRight();
- ptzStopMoving();
- ptzResetPosition();
- getPTZSpeed();
- setPTZSpeed(0-4);
- getPTZSelfTestMode();
- setPTZSelfTestMode(0-2);
- getPTZPrePointForSelfTest();
- setPTZPrePointForSelfTest(name);

// Cloud & push controls (not supported by 3518A based cameras)
- getCloudConfig();
- setCloudConfig(...);
- getCloudServer();
- setCloudServer(...);
- testCloudServer();
- refreshCloudToken();
- refreshCloudQuota();
- getCloudStreamLevel();
- setCloudStreamLevel(0-100);
- getCloudAuthcode();
- isCloudEnabled();

- getPushConfig();
- setPushConfig(...);
- getPushServer();
- setPushServer(...);
- testPushServer();
- sendPush(...);
- isPushEnabled();

// Miscellaneous controls (not supported by all platforms, see javadoc!)
- getHumidity();
- getNightlightState();
- setNightlightState(true/false);
- getLedState();
- setLedState(true/false);
- getHDRState();
- setHDRState(true/false);

// Deprecated, kept for backwards compatibility
- doesCameraSupportOnvif();
- doesCameraSupportRtsp();
```

See [javadoc](https://hypothermic.nl/foscamlib/javadoc/) for more information and details about these features.

## Changelog
v1.09
- Added IPConfig controls and container
- Added getUserPrivilege()
- Added NetUtil class
- Fixed enum: Privilege

v1.08
- Added cloud controls
- Added push controls
- Added night light controls
- Added humidity getter
- Added HDR controls

v1.07
- Added storage controls
- Added audio volume controls
- Added PTZ cruise controls
- Added getters for image attributes
- Renamed project from FoscamLib to FoscamAPI
    - Maven artifactId was not renamed

v1.06
- Added RS485 controls
- Added more PTZ controls
- Added many Wi-Fi controls
- Added system time controls
- Reworked NetManager execution into a single method, old methods are now deprecated
- Reworked all methods in Foscam.java to use the new exec() method
- Moved core components to "core" package
- Deprecated NetManager exec() methods are now removed

v1.05
- Added user account controls
- Added local alarm record config
- Added PTZ controls and PTZ speed controls
- Added motion detection functionality (beta):
    - Motion detect config
    - Motion detect schedule map
    - Motion detect area map
- Added H264 stream settings
- Fixed NetExecutor (see commit changes)

v1.04
- Added camera stream controls.
- Created Maven Repository. See "Maven dependency" above for details. (branch "mvn-repo")

v1.03
- Added all info flags
- Added DeviceInfo
- doesCameraSupportOnvif and Rtsp are now deprecated.
- Added firewall controls
- Added log controls
- Added config exporting control
- Added snapPicture()

v1.02
- Added FTP configuration controls
- Added Infrared light and config controls
- Added getName and setName

v1.01
- Added PortInfo and port getters
- Added get/set for UPnP

v1.00
- Initial release

## Troubleshooting
If you are having issues with FoscamAPI or any component:
1. Make sure your camera firmware is up to date. Do not ignore this step.
2. Check the [javadoc](https://hypothermic.nl/foscamlib/javadoc/) if you are using the method correctly.
3. Open an [issue](/../../issues/) where you describe the problem you're having. Include your camera model and firmware version.

## Mentions
FoscamAPI (previously named FoscamLib) is not affiliated, associated, authorized, endorsed by, or in any way officially connected with Shenzhen Foscam Intelligent Technology Limited, or any of its subsidiaries or its affiliates. The official Foscam website can be found at https://www.foscam.com. The name “Foscam” as well as related names, marks, emblems and images are registered trademarks of Shenzhen Foscam Intelligent Technology Limited.

If there are any legal issues, please contact me via GitHub or email (admin@hypothermic.nl)

## License
The license can be found [here](./LICENSE.txt) or in the root folder of the project.

## Sources
`http://www.camarasip.es/descarga/IP_Camera_CGI_(SDK).pdf`  
`https://www.foscam.es/descarga/Foscam-IPCamera-CGI-User-Guide-AllPlatforms-2015.11.06.pdf`