package com.panch.kotlinmvp.pages.fragmentBased.profile.model

/**
 * Created by Panch on 4.10.2017.
 */
data class Profile
(
        val id: Int,
        val profilePictureUrl: String,
        val name: String,
        val surname: String,
        val nickname: String
)