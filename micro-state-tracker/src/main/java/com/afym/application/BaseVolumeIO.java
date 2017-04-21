package com.afym.application;

import com.afym.config.VolumePersist;

public class BaseVolumeIO {
    protected VolumePersist volumePersist;
    protected boolean state;

    public BaseVolumeIO(){
        this.volumePersist = new VolumePersist();
    }

    public boolean getState(){
        return this.state;
    }
}
