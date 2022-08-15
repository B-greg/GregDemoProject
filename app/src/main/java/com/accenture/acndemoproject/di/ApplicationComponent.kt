package com.accenture.acndemoapplication.di

import com.accenture.acndemoproject.view.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

     fun injectListActivity(activity: MainActivity)


}
