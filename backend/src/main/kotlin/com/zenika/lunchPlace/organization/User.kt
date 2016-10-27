package com.zenika.lunchPlace.organization

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class User(val firstname: String = "",
                val lastname: String = "",
                val nickname:String = "",
                @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
                val id: Long = 0)
