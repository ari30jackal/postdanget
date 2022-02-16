package com.digimaster.daylima.data.di


import com.digimaster.daylima.viewmodel.JobViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HomeModule::class])
interface HomeComponent {

fun injectJob(jobViewModel: JobViewModel)
}
