package com.safe.systemOfWork.utils

import com.safe.systemOfWork.model.Conversation

class Data {
    companion object {
        fun convertDataToHashMap(conversation: Conversation): HashMap<String, Any> {
            return hashMapOf(
                "date" to conversation.date,
                "time" to conversation.time,
                "site" to conversation.site,
                "observerName" to conversation.observerName,
                "whereObserved" to conversation.whereObserved,
                "personObservedName" to conversation.personObservedName,
                "taskObserved" to conversation.taskObserved,
                "behaviourObserved" to conversation.behaviourObserved,
                "causeOfUnsafe" to conversation.causeOfUnsafe,
                "comment" to conversation.comment,
                "actionCode" to conversation.actionCode,
                "manualHandle" to conversation.behaviourCodes.manualHandle,
                "PPE" to conversation.behaviourCodes.PPE,
                "MHE" to conversation.behaviourCodes.MHE,
                "workplace" to conversation.behaviourCodes.workplace,
                "workEquipment" to conversation.behaviourCodes.workEquipment,
                "roadTransport" to conversation.behaviourCodes.roadTransport,
                "procedure" to conversation.behaviourCodes.procedure
            )
        }
    }
}