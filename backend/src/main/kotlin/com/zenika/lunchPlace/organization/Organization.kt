package com.zenika.lunchPlace.organization

import org.springframework.data.annotation.Id
import java.io.Serializable

data class Organization(val name: String = "",
                        val teams: MutableList<Team> = mutableListOf<Team>(),

                        @Id val id: String? = null) : Serializable
