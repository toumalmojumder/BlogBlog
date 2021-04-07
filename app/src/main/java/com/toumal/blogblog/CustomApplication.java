package com.toumal.blogblog;

import android.app.Application;

import com.toumal.blogblog.dagger2.DaggerNetworkComponent;
import com.toumal.blogblog.dagger2.NetworkComponent;
import com.toumal.blogblog.dagger2.NetworksModule;



public class CustomApplication extends Application {
    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .networksModule(new NetworksModule(Helper.URL))
                .build();
    }
    public NetworkComponent getNetworkComponent(){
        return networkComponent;
    }
}
