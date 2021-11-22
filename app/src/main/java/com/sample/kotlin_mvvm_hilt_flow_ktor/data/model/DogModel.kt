package com.sample.kotlin_mvvm_hilt_flow_ktor.data.model


/**
 * @author Ashik
 * Created on 22/11/21 .
 */
data class DogModel(
    val id: Int,
    val name: String,
    val bred_for: String,
    val breed_group: String,
    val life_span: String,
    val temperament: String,
    val origin: String,
    val reference_image_id: String,
    val image: DogsImages,
    val height: DogHeight,
    val weight: DogWeight
)


data class DogsImages(val url: String)

data class DogHeight(val imperial: String, val metric: String)

data class DogWeight(val imperial: String, val metric: String)
