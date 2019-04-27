package com.sashamakkar.medicare;

import android.net.Uri;

public class Report {
    Uri uri;

    public Report(Uri uriObject) {
        this.uri = uriObject;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
