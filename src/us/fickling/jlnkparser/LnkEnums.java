/*
 * LNK File Parser
 *
 * Copyright 2012 Dick Fickling
 * Contact: dick <at> fickling <dot> us
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.fickling.jlnkparser;

import java.util.UUID;

/**
 *
 * @author dick
 */
public class LnkEnums {
    
    private static final UUID CNETROOT = UUID.fromString("208D2C60-3AEA-1069-A2D7-08002B30309D");
    private static final UUID CDRIVES = UUID.fromString("20D04FE0-3AEA-1069-A2D8-08002B30309D");
    private static final UUID CMYDOCS = UUID.fromString("450D8FBA-AD25-11D0-98A8-0800361B1103");
    private static final UUID WIN7LIBRARIES = UUID.fromString("031E4825-7B94-4DC3-B131-E946B44C8DD");
    private static final UUID WIN7RECENT = UUID.fromString("22877A6D-37A1-461A-91B0-DBDA5AAEBC99");
    private static final UUID WINVISTACONTROLPANEL = UUID.fromString("5399E694-6CE5-4D6C-8FCE-1D8870FDCBA0");
    private static final UUID WIN7CONTROLPANEL = UUID.fromString("26EE0668-A00A-44D7-9371-BEB064C98683");
    private static final UUID WINVISTAHELP = UUID.fromString("2559A1F1-21D7-11D4-BDAF-00C04F60B9F0");
    private static final UUID WINVISTA7RUN = UUID.fromString("2559A1F3-21D7-11D4-BDAF-00C04F60B9F0");
    private static final UUID WINVISTA7EMAIL = UUID.fromString("2559A1F5-21D7-11D4-BDAF-00C04F60B9F0");
    private static final UUID WINVISTA7DESKTOP = UUID.fromString("3080F90D-D7AD-11D9-BD98-0000947B0257");
    private static final UUID WINVISTASWITCHER = UUID.fromString("3080F90E-D7AD-11D9-BD98-0000947B0257");
    private static final UUID WINVISTAPUBLIC = UUID.fromString("4336A54D-038B-4685-AB02-99BB52D3FB8B");
    private static final UUID WINVISTA7SPECIAL = UUID.fromString("59031A47-3F72-44A7-89C5-5595FE6B30EE");
    private static final UUID WINVISTARECYCLE = UUID.fromString("645FF040-5081-101B-9F08-00AA002F954E");
    private static final UUID WINVISTA7GAME = UUID.fromString("ED228FDF-9EA8-4870-83B1-96B02CFE0D52");
    private static final UUID WIN7CONTROLPANELSUBSET = UUID.fromString("ED7BA470-8E54-465E-825C-99712043E01C");
    private static final UUID IEFRAME = UUID.fromString("871C5380-42A0-1069-A2EA-08002B30309D");

    public enum CommonCLSIDS {
        CNetRoot(CNETROOT),
        CDrivesFolder(CDRIVES),
        CMyDocsFolder(CMYDOCS),
        Win7Libraries(WIN7LIBRARIES),
        Win7Recent(WIN7RECENT),
        WinVistaControlPanel(WINVISTACONTROLPANEL),
        Win7ControlPanel(WIN7CONTROLPANEL),
        WinVistaHelp(WINVISTAHELP),
        WinVista7Run(WINVISTA7RUN),
        WinVista7Email(WINVISTA7EMAIL),
        WinVista7Desktop(WINVISTA7DESKTOP),
        WinVistaSwitcher(WINVISTASWITCHER),
        WinVistaPublic(WINVISTAPUBLIC),
        WinVista7Special(WINVISTA7SPECIAL),
        WinVistaRecycle(WINVISTARECYCLE),
        WinVista7Game(WINVISTA7GAME),
        Win7ControlPanelSubset(WIN7CONTROLPANELSUBSET),
        IEFrameDLL(IEFRAME),
        Unknown(new UUID(0, 0));
        
        private UUID flag;
        
        private CommonCLSIDS(UUID flag) {
            this.flag = flag;
        }
        
        static CommonCLSIDS valueOf(UUID type) {
            for(CommonCLSIDS value : CommonCLSIDS.values()) {
                if(value.flag.equals(type)) {
                    return value;
                }
            }
            return Unknown;
        }
    }
    
    public enum LinkFlags {
        HasLinkTargetIDList(0x00000001),
        HasLinkInfo(0x00000002),
        HasName(0x00000004),
        HasRelativePath(0x00000008),
        HasWorkingDir(0x00000010),
        HasArguments(0x00000020),
        HasIconLocation(0x00000040),
        IsUnicode(0x00000080),
        ForceNoLinkInfo(0x00000100),
        HasExpString(0x00000200),
        RunInSeparateProcess(0x00000400),
        Unused1(0x00000800),
        HasDarwinID(0x00001000),
        RunAsUser(0x00002000),
        HasExpIcon(0x00004000),
        NoPidlAlias(0x00008000),
        Unused2(0x00010000),
        RunWithShimLayer(0x00020000),
        ForceNoLinkTrack(0x00040000),
        EnableTargetMetaData(0x00080000),
        DisableLinkPathTracking(0x00100000),
        DisableKnownFolderTracking(0x00200000),
        DisableKnownFolderAlias(0x00400000),
        AllowLinkToLink(0x00800000),
        UnaliasOnSave(0x01000000),
        PreferEnvironmentPath(0x02000000),
        KeepLocalIDListForUNCTarget(0x04000000);
        
        private int flag;
        
        private LinkFlags(int flag) {
            this.flag = flag;
        }
        
        public int getFlag() {
            return flag;
        }
    }
    
    public enum DriveType {
        DRIVE_UNKNOWN(0x00000000),
        DRIVE_NO_ROOT_DIR(0x00000001),
        DRIVE_REMOVABLE(0x00000002),
        DRIVE_FIXED(0x00000003),
        DRIVE_REMOTE(0x00000004),
        DRIVE_CDROM(0x00000005),
        DRIVE_RAMDISK(0x00000006);
        
        private int flag;
        
        private DriveType(int flag) {
            this.flag = flag;
        }
        
        public int getFlag() {
            return flag;
        }
        
        static DriveType valueOf(int type) {
            for(DriveType value : DriveType.values()) {
                if(value.flag == type) {
                    return value;
                }
            }
            return DRIVE_UNKNOWN;
        }
    }
    
    public enum FileAttributesFlags {
        READONLY(0x00000001),
        HIDDEN(0x00000002),
        SYSTEM(0x00000004),
        RESERVED1(0x00000008),
        DIRECTORY(0x00000010),
        ARCHIVE(0x00000020),
        RESERVED2(0x00000040),
        NORMAL(0x00000080),
        TEMPORARY(0x00000100),
        SPARSE_FILE(0x00000200),
        REPARSE_POINT(0x00000400),
        COMPRESSED(0x00000800),
        OFFLINE(0x00001000),
        NOT_CONTENT_INDEXED(0x00002000),
        ENCRYPTED(0x00004000);
        
        private int flag;
        
        private FileAttributesFlags(int flag) {
            this.flag = flag;
        }
        
        public int getFlag() {
            return flag;
        }
    }
    
    public enum LinkInfoFlags {
        VolumeIDAndLocalBasePath(0x00000001),
        CommonNetworkRelativeLinkAndPathSuffix(0x00000002);
        
        private int flag;
        
        private LinkInfoFlags(int flag) {
            this.flag = flag;
        }
        
        public int getFlag() {
            return flag;
        }
    }
    
    
    public enum CommonNetworkRelativeLinkFlags {
        ValidDevice(0x00000001),
        ValidNetType(0x00000002);
        
        private int flag;
        
        private CommonNetworkRelativeLinkFlags(int flag) {
            this.flag = flag;
        }
        
        public int getFlag() {
            return flag;
        }
    }
    
    public enum NetworkProviderType {
        WNNC_NET_AVID(0x001A0000),
        WNNC_NET_DOCUSPACE(0x001B0000),
        WNNC_NET_MANGOSOFT(0x001C0000),
        WNNC_NET_SERNET(0x001D0000),
        WNNC_NET_RIVERFRONT1(0x001E0000),
        WNNC_NET_RIVERFRONT2(0x001F0000),
        WNNC_NET_DECORB(0x00200000),
        WNNC_NET_PROTSTOR(0x00210000),
        WNNC_NET_FJ_REDIR(0x00220000),
        WNNC_NET_DISTINCT(0x00230000),
        WNNC_NET_TWINS(0x00240000),
        WNNC_NET_RDR2SAMPLE(0x00250000),
        WNNC_NET_CSC(0x00260000),
        WNNC_NET_3IN1(0x00270000),
        WNNC_NET_EXTENDNET(0x00290000),
        WNNC_NET_STAC(0x002A0000),
        WNNC_NET_FOXBAT(0x002B0000),
        WNNC_NET_YAHOO(0x002C0000),
        WNNC_NET_EXIFS(0x002D0000),
        WNNC_NET_DAV(0x002E0000),
        WNNC_NET_KNOWARE(0x002F0000),
        WNNC_NET_OBJECT_DIRE(0x00300000),
        WNNC_NET_MASFAX(0x00310000),
        WNNC_NET_HOB_NFS(0x00320000),
        WNNC_NET_SHIVA(0x00330000),
        WNNC_NET_IBMAL(0x00340000),
        WNNC_NET_LOCK(0x00350000),
        WNNC_NET_TERMSRV(0x00360000),
        WNNC_NET_SRT(0x00370000),
        WNNC_NET_QUINCY(0x00380000),
        WNNC_NET_OPENAFS(0x00390000),
        WNNC_NET_AVID1(0x003A0000),
        WNNC_NET_DFS(0x003B0000),
        WNNC_NET_KWNP(0x003C0000),
        WNNC_NET_ZENWORKS(0x003D0000),
        WNNC_NET_DRIVEONWEB(0x003E0000),
        WNNC_NET_VMWARE(0x003F0000),
        WNNC_NET_RSFX(0x00400000),
        WNNC_NET_MFILES(0x00410000),
        WNNC_NET_MS_NFS(0x00420000),
        WNNC_NET_GOOGLE(0x00430000),
        WNNC_NET_UNKNOWN(0x00000000);
        
        private int flag;
        
        private NetworkProviderType(int flag) {
            this.flag = flag;
        }
        
        static NetworkProviderType valueOf(int type) {
            for(NetworkProviderType value : NetworkProviderType.values()) {
                if(value.flag == type) {
                    return value;
                }
            }
            return WNNC_NET_UNKNOWN;
        }
        
        public int getFlag() {
            return flag;
        }
    }
}
