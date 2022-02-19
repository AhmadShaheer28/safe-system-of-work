package com.safe.systemOfWork.model

import java.io.Serializable

class Conversation: Serializable {
    var id = ""
    var date = ""
    var time = ""
    var site = ""
    var observerName = ""
    var whereObserved = ""
    var personObservedName = ""
    var taskObserved = ""
    var behaviourCodes = BehaviourCodes()
    var behaviourObserved = ""
    var causeOfUnsafe = ""
    var comment = ""
    var actionCode = ""

    companion object {
        fun mapToObject(conversation: MutableMap<String, Any>, id: String) : Conversation {
            var con = Conversation()

            con.id = id
            con.date = conversation["date"] as String
            con.time = conversation["time"] as String
            con.site = conversation["site"] as String
            con.observerName = conversation["observerName"] as String
            con.whereObserved = conversation["whereObserved"] as String
            con.personObservedName = conversation["personObservedName"] as String
            con.taskObserved = conversation["taskObserved"] as String
            con.behaviourObserved = conversation["behaviourObserved"] as String
            con.causeOfUnsafe = conversation["causeOfUnsafe"] as String
            con.comment = conversation["comment"] as String
            con.actionCode = conversation["actionCode"] as String
            con.behaviourCodes.manualHandle = conversation["manualHandle"] as String
            con.behaviourCodes.PPE = conversation["PPE"] as String
            con.behaviourCodes.MHE = conversation["MHE"] as String
            con.behaviourCodes.workplace = conversation["workplace"] as String
            con.behaviourCodes.workEquipment = conversation["workEquipment"] as String
            con.behaviourCodes.roadTransport = conversation["roadTransport"] as String
            con.behaviourCodes.procedure = conversation["procedure"] as String


            return con
        }
    }

}