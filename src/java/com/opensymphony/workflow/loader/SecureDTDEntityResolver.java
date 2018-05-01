/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.loader;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Resolves external references to the os-workflow DTD to a well known document in the local file system, and disallows
 * any other external entity references.
 *
 * @author Oswaldo Hernandez (ohernandez@atlassian.com)
 */
public class SecureDTDEntityResolver implements EntityResolver {
    //~ Methods ////////////////////////////////////////////////////////////////

    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (systemId == null) {
            return failure();
        }

        try {
            final URL url = new URL(systemId);
            String file = url.getFile();

            if ((file != null) && (file.indexOf('/') > -1)) {
                file = file.substring(file.lastIndexOf('/') + 1);
            }

            if (isOpenSymphonyUrl(url) && isDtdReference(systemId)) {
                return localDtd(file);
            }
        }
        //modified by mbussetti - 15 nov 2004
        //if the systemId isn't an URL, it is searched in the usual classpath
         catch (MalformedURLException e) {
            return localDtd(systemId);
        }

        return failure();
    }

    private boolean isDtdReference(final String systemId) {
        return systemId.endsWith(".dtd");
    }

    private boolean isOpenSymphonyUrl(final URL url) {
        return "www.opensymphony.com".equals(url.getHost());
    }

    /**
     * <p>Disallow unknown entities by returning an empty InputSource.<p/>
     *
     * <p>Consequently, when parsing malicious input, the empty InputSource returned by the custom resolver causes
     * a java.net. MalformedURLException to be thrown.</p>
     *
     * @return An empty InputSource.
     */
    private InputSource failure() {
        return new InputSource();
    }

    /**
     * Attempts to load the DTD from the classpath, and fail if this is not possible.
     *
     * @param fileName The name of the file containing the dtd to retrieve.
     * @return An input source for a dtd retrieved from the class path, or an empty input source if it can not be found.
     */
    private InputSource localDtd(final String fileName) {
        InputStream is = getClass().getResourceAsStream("/META-INF/" + fileName);

        if (is == null) {
            is = getClass().getResourceAsStream('/' + fileName);
        }

        if (is != null) {
            return new InputSource(is);
        }

        return failure();
    }
}
