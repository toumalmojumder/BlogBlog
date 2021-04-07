package com.toumal.blogblog.dagger2;

import com.toumal.blogblog.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworksModule.class})
public interface NetworkComponent {
    public void inject(MainActivity activity);
}

