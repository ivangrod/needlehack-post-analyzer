package com.ivangrod.needlehackpost.infrastructure.post.messaging.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostMessage(val title: String, val uri: String, val publicationAt: String)
