package com.vfpowertech.moejackson

import com.fasterxml.jackson.annotation.JsonProperty

class InstallationData(
    @JsonProperty("installationId")
    val installationId: String
)