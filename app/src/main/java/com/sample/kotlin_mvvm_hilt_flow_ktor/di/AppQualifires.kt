package com.sample.kotlin_mvvm_hilt_flow_ktor.di

import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DatabaseName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TestData


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RandomeUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GsonConverter


