package com.qa.wave1;

import org.testng.annotations.Test;
import com.qa.demo.base.CommonMethods;

public class CLM extends CommonMethods {


	@Test(enabled = true, priority =1, groups = "Prod")
	public void CLM_CCCONAPPPRDN01() {
		verifyWinSerStatus("CCCONAPPPRDN01", "Arcsight cceu_ad_wuc_QualGMPCC", "Running", "Auto");
		verifyWinSerStatus("CCCONAPPPRDN01", "Arcsight cceu_asafwl_syslog", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =2,groups = "Prod")
	public void CLM_EOCONAPPPRDN02() {
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		verifyWinSerStatus("EOCONAPPPRDN02", "ArcSight Microsoft DNS Trace Log Multiple Server File", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =3,groups = "Prod")
	public void CLM_FCCONAPPPRDN01() {
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight arcsight Flexconnector DC file reader", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "arcsight microsoft DHCP file", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight microsoft forefront threat management gateway file", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight microsfot IIS multiple server file-Avaiter", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Microsoft DNS trace log multiple server file", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Microsoft DNS trace log multiple server file2", "Running", "Auto");verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "ArcSight Microsoft Windows Event Log - Unified2", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Microsoft Windows event log-unified", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight microsoft windows event log -ADFS", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight microsoft windows event log -ARS", "Running", "Auto");
		verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight sep_DCS_Prod", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Symantec endpoint prodution db", "Running", "Auto");
		//verifyWinSerStatus("FCCONAPPPRDN01", "Arcsight Symantec endpoint prodution 14db", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =4,groups = "Prod")
	public void CLM_HGCONAPPPRDN02() {
		//verifyWinSerStatus("HGCONAPPPRDN02", "Arcsight  blue coat proxy SG multiple server file", "Running", "Auto");
		//verifyWinSerStatus("HGCONAPPPRDN02", "Arcsight  blue coat proxy SG multiple server file to Netskope", "Running", "Auto");
			}
	
	@Test(enabled = true, priority =5,groups = "Prod")
	public void CLM_LDCONAPPPRDN01() {
		verifyWinSerStatus("LDCONAPPPRDN01", "Arcsight blue coat proxy SG multiple server file", "Running", "Auto");
		//verifyWinSerStatus("LDCONAPPPRDN01", "Arcsight Microsft DNS trace log multiple server file", "Running", "Auto");
		//verifyWinSerStatus("LDCONAPPPRDN01", "Arcsight microsoft windows event log unified", "Running", "Auto");
		//verifyWinSerStatus("LDCONAPPPRDN01", "Arcsight Microsft DNS trace log multiple server file2", "Running", "Auto");
		//verifyWinSerStatus("LDCONAPPPRDN01", "Arcsight microsoft windows event log unified2", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =6,groups = "Prod")
	public void CLM_SJCLMAPPPRDN01() {
		//verifyWinSerStatus("SJCLMAPPPRDN01", "Arcsight microsoft windows event log-native", "Running", "Auto");
	}

	@Test(enabled = true, priority =7,groups = "Prod")
	public void CLM_SJCONAPPPRDN01() {
		verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight fireeye syslog daemon", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight Microsft DNS trace log multiple server file", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight microsoft windows event log unified", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight Microsft DNS trace log multiple server file2", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight microsoft windows event log unified2", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight cisco ASA FW syslog daemon", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN01", "Arcsight bit9+carbon  black syslog daemon", "Running", "Auto");
	}
	
	@Test(enabled = true, priority =8,groups = "Prod")
	public void CLM_SJCONAPPPRDN02() {
		//verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight arcsight flexconnector multiple folder file -Druva insync", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight arcsight flexconnector  regex  folder file -CSV_share file", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight Microsft DNS trace log multiple server file", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight sjna2_pulse_secure_syslog 8514", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight microsoft windows event log unified", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN02", "Arcsight syslog daemon", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =9,groups = "Prod")
	public void CLM_SJCONAPPPRDN03() {
		verifyWinSerStatus("SJCONAPPPRDN03", "Arcsight AZURE_Portal_1999_v7_13", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN03", "Arcsight microsoft exchange message tracking log multiple server file2", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN03", "Arcsight microsoft exchange message tracking log multiple server file", "Running", "Auto");
		
	}
	
	@Test(enabled = true, priority =10,groups = "Prod")
	public void CLM_SJCONAPPPRDN13() {
		//verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight arcsight flexconnector multiple folder file -Ping federatre", "Running", "Auto");
		//verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight service -now _syslog daemon", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight SJ_symantec_DLP_EU_syslog", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight SJ_symantec_DLP_NA_syslog", "Running", "Auto");
		verifyWinSerStatus("SJCONAPPPRDN13", "Arcsight syslog daemon_attivo", "Running", "Auto");
	}
	
}