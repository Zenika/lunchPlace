package com.zenika.lunchPlace.organization

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Organization(val name: String = "",
                        @OneToMany
                        val teams: MutableList<Team> = mutableListOf<Team>(),
                        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                        val id: Long = 0) : Serializable
