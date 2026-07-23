package com.startapp.networkTest;

import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.enums.AnonymizationLevel;
import com.startapp.networkTest.enums.BatteryStatusUploadConstraints;
import com.startapp.networkTest.enums.CtCriteriaTypes;
import com.startapp.networkTest.enums.LtrCriteriaTypes;
import com.startapp.networkTest.enums.TrafficDetectionMode;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class a {
    private String PROJECT_ID = "0";
    private String CAMPAIGN_ID = "Campaign001";
    private String UPLOAD_DUS_URL = "https://awsdus.api.p3insight.de/isupload/upload_check_lumen.php";
    private String UPLOAD_TICKET_URL = "https://ul.api.c0nnectthed0ts.com/ul/v3/";
    private boolean UPLOAD_ENABLED_IN_ROAMING = true;
    private boolean UPLOAD_ENABLED_IN_ROAMING_WIFI = this.UPLOAD_ENABLED_IN_ROAMING;
    private long UPLOAD_TIMESPAN_BETWEEN_UPLOADS = 57600000;
    private long UPLOAD_TIMESPAN_BETWEEN_UPLOADS_WIFI = 14400000;
    private long UPLOAD_TIMESPAN_BETWEEN_EXPORTS = this.UPLOAD_TIMESPAN_BETWEEN_UPLOADS;
    private BatteryStatusUploadConstraints UPLOAD_BATTERY_STATUS_CONSTRAINT = BatteryStatusUploadConstraints.Always;
    private boolean UPLOAD_INFORMATION_ENABLED = false;
    private boolean CONNECTIVITY_TEST_ENABLED = false;
    private boolean CONNECTIVITY_KEEPALIVE_ENABLED = false;
    private String CONNECTIVITY_TEST_HOSTNAME = "";
    private String CONNECTIVITY_TEST_FILENAME = "";
    private String CONNECTIVITY_TEST_IP = "";
    private boolean CONNECTIVITY_TEST_ENABLED_IN_ROAMING = true;
    private long CONNECTIVITY_KEEPALIVE_INTERVAL = 86400000;
    private long CONNECTIVITY_TEST_INTERVAL = 900000;
    private float CONNECTIVITY_TEST_MIN_BATTERY_LEVEL = 15.0f;
    private String CONNECTIVITY_TEST_TRUSTSTORE_URL = "https://d2to8y50b3n6dq.cloudfront.net/truststores/[PROJECTID]/truststore.zip";
    private boolean CONNECTIVITY_TEST_VERIFY_TRUSTSTORE_SIGNATURE = false;
    private long CONNECTIVITY_TEST_TRUSTSTORE_UPDATE_INTERVAL = 86400000;
    private long CONNECTIVITY_TEST_CDNCONFIG_UPDATE_INTERVAL = 86400000;
    private String CONNECTIVITY_TEST_CDNCONFIG_URL = "https://d2to8y50b3n6dq.cloudfront.net/truststores/[PROJECTID]/cdnconfig.zip";
    private boolean CONNECTIVITY_TEST_VERIFY_CDNCONFIG_SIGNATURE = false;
    private boolean CONNECTIVITY_TEST_ALLOW_IN_IDLE = false;
    private boolean APPUSAGE_SERVICE_ENABLED = false;
    private boolean APPUSAGE_MANAGER_INSTALLED_APP_SNAPSHOT_ENABLED = false;
    private boolean APPUSAGE_BROWSER_SESSION_TRACKING_ENABLED = false;
    private TrafficDetectionMode APPUSAGE_TRAFFIC_DETECTION_MODE = TrafficDetectionMode.Auto;
    private boolean INSTALLED_APP_SNAPSHOT_PERMISSIONS_ENABLED = false;
    private boolean INSTALLED_APP_SNAPSHOT_SIGNATURES_ENABLED = false;
    private boolean COVERAGE_MAPPER_SERVICE_ENABLED = false;
    private LocationController.ProviderMode COVERAGE_MAPPER_SERVICE_TRIGGER_PROVIDER_MODE = LocationController.ProviderMode.Gps;
    private long COVERAGE_MAPPER_SERVICE_OUT_OF_SERVICE_MEASUREMENT_DUARTION = 0;
    private long COVERAGE_MAPPER_SERVICE_CELL_ID_CHANGE_MEASUREMENT_DUARTION = 0;
    private AnonymizationLevel VOICEMANAGER_PHONENUMBER_RECORD_TYPE = AnonymizationLevel.None;
    private LocationController.ProviderMode VOICEMANAGER_LOCATIONPROVIDER = LocationController.ProviderMode.GpsAndNetwork;
    private LocationController.ProviderMode VOICEMANAGER_LOCATIONPROVIDER_DROPPEDWINDOW = LocationController.ProviderMode.Passive;
    private boolean VOICEMANAGER_SAVE_DROPPEDWINDOW_MPVS = false;
    private boolean VOICEMANAGER_USE_READ_CALL_LOG_PERMISSION = true;
    private LocationController.ProviderMode LTR_LOCATIONPROVIDER = LocationController.ProviderMode.Passive;
    private AnonymizationLevel MESSAGINGMANAGER_PHONENUMBER_RECORD_TYPE = AnonymizationLevel.None;
    private boolean VOICE_SERVICE_ENABLED = false;
    private boolean MESSAGING_SERVICE_ENABLED = false;
    private boolean VOWIFI_TEST_MANAGER_ENABLED = false;
    private long GUID_MAX_AGE = 15552000000L;
    private boolean STATSMANAGER_ENABLED = false;
    private boolean STATSMANAGER_LEGACY_ENABLED = false;
    private boolean STATSMANAGER_USE_NTR_FOR_RATSHARE_AND_SIGNALSTRENGTH = false;
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_2G = {-57, -79, -89, -99};
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_3G = {-65, -85, -95, -101};
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_4G = {-79, -92, -112, -124};
    private int[] STATSMANAGER_SIGNAL_STRENGTH_MAPPING_5G = {-95, -105, -115, -120};
    private long STATSMANAGER_ENTRIES_MAX_AGE_DAYS = 30;
    private long DATABASE_ENTRIES_MAX_AGE_DAYS = 30;
    private boolean TRAFFIC_ANALYZER_ENABLED = false;
    private boolean TRAFFIC_ANALYZER_MPT_ENABLED = false;
    private boolean QOE_MANAGER_ENABLED = false;
    private boolean SEND_REGISTRATION_TIMESTAMP_ENABLED = false;
    private String GEOIP_URL = "https://geoip.api.c0nnectthed0ts.com/geoip/";
    private boolean GEOIP_MOBILE_ENABLED = false;
    private String P3ST_CONTROL_SERVER = "control.st.p3insight.de";
    private int P3ST_CUSTOM_TCP_PORT = 20000;
    private boolean START_SERVICES_IN_FOREGROUND = false;
    private boolean BANDWDITH_TEST_MANAGER_GET_IMEI_IMSI = false;
    private boolean APPUSAGE_MEASURE_ALL_MPA = false;
    private long CORE_EXPIRATION_TIMESTAMP = -1;
    private AnonymizationLevel WIFIINFO_SSID_RECORDTYPE = AnonymizationLevel.Full;
    private AnonymizationLevel WIFIINFO_BSSID_RECORDTYPE = AnonymizationLevel.Full;
    private AnonymizationLevel WIFISCAN_SSID_RECORDTYPE = AnonymizationLevel.None;
    private AnonymizationLevel WIFISCAN_BSSID_RECORDTYPE = AnonymizationLevel.None;
    private AnonymizationLevel SIMINFO_ICCID_RECORDTYPE = AnonymizationLevel.Anonymized;
    private AnonymizationLevel SIMINFO_IMSI_RECORDTYPE = AnonymizationLevel.Anonymized;
    private boolean NTP_SYNC_ENABLED = true;
    private String VOWIFI_TEST_PORT_TEST_SERVER_URL = "";
    private String VOWIFI_TEST_EPDG_SERVER_URL = "";
    private String VOWIFI_TEST_EPDG_LATENCY_IP = "";
    private boolean NIR_COLLECT_CELLINFO = false;
    private int NIR_COLLECT_CELLINFO_THRESHOLD = 1;
    private boolean VC_COLLECT_CELLINFO = false;
    private boolean CT_COLLECT_CELLINFO = false;
    private boolean CLEAR_AUS_LOCATION_INFO = false;
    private boolean CLEAR_CT_LOCATION_INFO = false;
    private boolean CLEAR_LTR_LOCATION_INFO = false;
    private boolean CLEAR_MSG_LOCATION_INFO = false;
    private boolean CLEAR_NF_LOCATION_INFO = false;
    private boolean CLEAR_NTR_LOCATION_INFO = false;
    private boolean CLEAR_RSS_LOCATION_INFO = false;
    private boolean CLEAR_WPT_LOCATION_INFO = false;
    private boolean CLEAR_VC_LOCATION_INFO = false;
    private String[] CONNECTIVITY_TEST_HOSTNAME_ARRAY = new String[0];
    private CtCriteriaTypes CONNECTIVITY_TEST_CRITERIA = CtCriteriaTypes.Random;
    private String[] LATENCY_TEST_HOSTNAME_ARRAY = new String[0];
    private LtrCriteriaTypes LATENCY_TEST_CRITERIA = LtrCriteriaTypes.CTItem;
    private long WIFI_SCAN_MINIMUM_INTERVAL = 600000;
    private boolean WIFI_SCAN_ENABLED = false;

    public final String a() {
        return this.PROJECT_ID;
    }

    public final boolean b() {
        return this.CONNECTIVITY_TEST_ENABLED;
    }

    public final boolean c() {
        return this.CONNECTIVITY_KEEPALIVE_ENABLED;
    }

    public final String d() {
        return this.CONNECTIVITY_TEST_HOSTNAME;
    }

    public final String e() {
        return this.CONNECTIVITY_TEST_FILENAME;
    }

    public final String f() {
        return this.CONNECTIVITY_TEST_IP;
    }

    public final boolean g() {
        return this.CONNECTIVITY_TEST_ENABLED_IN_ROAMING;
    }

    public final float h() {
        return this.CONNECTIVITY_TEST_MIN_BATTERY_LEVEL;
    }

    public final String i() {
        return this.CONNECTIVITY_TEST_TRUSTSTORE_URL;
    }

    public final boolean j() {
        return this.CONNECTIVITY_TEST_VERIFY_TRUSTSTORE_SIGNATURE;
    }

    public final long k() {
        return this.CONNECTIVITY_TEST_TRUSTSTORE_UPDATE_INTERVAL;
    }

    public final long l() {
        return this.CONNECTIVITY_TEST_CDNCONFIG_UPDATE_INTERVAL;
    }

    public final String m() {
        return this.CONNECTIVITY_TEST_CDNCONFIG_URL;
    }

    public final boolean n() {
        return this.CONNECTIVITY_TEST_VERIFY_CDNCONFIG_SIGNATURE;
    }

    public final LocationController.ProviderMode o() {
        return this.LTR_LOCATIONPROVIDER;
    }

    public final long p() {
        return this.GUID_MAX_AGE;
    }

    public final boolean q() {
        return this.SEND_REGISTRATION_TIMESTAMP_ENABLED;
    }

    public final String r() {
        return this.GEOIP_URL;
    }

    public final boolean s() {
        return this.GEOIP_MOBILE_ENABLED;
    }

    public final boolean t() {
        return this.BANDWDITH_TEST_MANAGER_GET_IMEI_IMSI;
    }

    public final AnonymizationLevel u() {
        return this.SIMINFO_ICCID_RECORDTYPE;
    }

    public final AnonymizationLevel v() {
        return this.SIMINFO_IMSI_RECORDTYPE;
    }

    public final boolean w() {
        return this.NTP_SYNC_ENABLED;
    }

    public final boolean x() {
        return this.NIR_COLLECT_CELLINFO;
    }

    public final int y() {
        return this.NIR_COLLECT_CELLINFO_THRESHOLD;
    }

    public final boolean z() {
        return this.CT_COLLECT_CELLINFO;
    }

    public final boolean A() {
        return this.CLEAR_CT_LOCATION_INFO;
    }

    public final boolean B() {
        return this.CLEAR_LTR_LOCATION_INFO;
    }

    public final String[] C() {
        return this.CONNECTIVITY_TEST_HOSTNAME_ARRAY;
    }

    public final CtCriteriaTypes D() {
        return this.CONNECTIVITY_TEST_CRITERIA;
    }

    public final String[] E() {
        return this.LATENCY_TEST_HOSTNAME_ARRAY;
    }

    public final LtrCriteriaTypes F() {
        return this.LATENCY_TEST_CRITERIA;
    }
}
