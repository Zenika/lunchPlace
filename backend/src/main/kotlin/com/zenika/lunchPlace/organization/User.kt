package com.zenika.lunchPlace.organization

import org.springframework.data.annotation.Id
import java.io.Serializable

data class User(val firstname: String = "",
                val lastname: String = "",
                val nickname: String = "",

                @Id val id: String? = null) : Serializable
