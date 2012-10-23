package edu.ku.it.si.b2example.util;

/**
 * Exposes constants defined in the bb-manifest file
 * @author Dr Malcolm Murray
 * @version 3.0
 */
public class ManifestSettings {

    private final static String vendorId = "kuit";
    private final static String handle = "b2_servlet_part_four";

    /**
     * Create a new instance of ManifestSettings
     **/
    public ManifestSettings() {

    }

    /**
     * Obtain the Vendor Id declared in the bb-manifest
     * @return vendor value (max 4 characters)
     */
    public static String getVendorId() {
        return vendorId;
    }

    /** Obtain the Building Block Handle declared in
     * the bb-manifest
     *
     * @return handle value
     */
    public static String getHandle() {
        return handle;
    }


    /**
     * Builds the Application Handle required by the CxComponent class
     * indicating what type of object the component listens for.
     * I think this is obtained by concatenating the vendorId, a hyphen
     * and the handle.
     * @return
     */
    public static String getApplicationHandle(){
        return getVendorId() + "-" + getHandle();
    }

 

}
