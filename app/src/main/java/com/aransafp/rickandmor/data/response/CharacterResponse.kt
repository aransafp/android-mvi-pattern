package com.aransafp.rickandmor.data.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(

    @field:SerializedName("results")
    val results: List<Character>,

)

data class Character(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("species")
	val species: String,

    @field:SerializedName("origin")
    val origin: Origin,

    @field:SerializedName("location")
    val location: Location,

	@field:SerializedName("image")
	val image: String,

)

data class Origin(

	@field:SerializedName("name")
	val name: String,

	)

data class Location(

    @field:SerializedName("name")
    val name: String,

)
