/**
* IAppContextHelper.java
*
* Created on   : 2010-08-13
* Target OS    : Java VM 1.6.0.17 
* CVS revision : $Revision: 1.1.1.1 $ 
*
* ------------------------------------------------------------
* CHANGE REVISION
* ------------------------------------------------------------
* DATE          AUTHOR      	                 REVISION    	
* 2010-08-13   	Total Soft Bank-Luis	         First release.
* ------------------------------------------------------------
* CLASS DESCRIPTION
* ------------------------------------------------------------
*
*/
package  com.dbcore.common;

public interface IAppContextHelper 
{    
    String[] getConfigFiles();
    void setConfigFiles(String[] configFiles);
}
