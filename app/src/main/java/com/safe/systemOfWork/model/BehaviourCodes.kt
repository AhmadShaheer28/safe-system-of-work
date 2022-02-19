package com.safe.systemOfWork.model

import java.io.Serializable

class BehaviourCodes: Serializable {
    var manualHandle = ""
    var PPE = ""
    var MHE = ""
    var workplace = ""
    var workEquipment = ""
    var roadTransport = ""
    var procedure = ""

    constructor(
        manualHandle: String = "",
        PPE: String = "",
        MHE: String = "",
        workplace: String = "",
        workEquipment: String = "",
        roadTransport: String = "",
        procedure: String = ""
    ) {
        this.manualHandle = manualHandle
        this.PPE = PPE
        this.MHE = MHE
        this.workplace = workplace
        this.workEquipment = workEquipment
        this.roadTransport = roadTransport
        this.procedure = procedure
    }
}