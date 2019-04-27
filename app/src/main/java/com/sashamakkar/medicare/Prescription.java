package com.sashamakkar.medicare;

import android.net.Uri;

public class Prescription {

    Uri uri;

    public Prescription(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
