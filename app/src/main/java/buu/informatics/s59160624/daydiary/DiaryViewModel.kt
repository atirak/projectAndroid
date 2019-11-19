/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package buu.informatics.s59160624.daydiary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import buu.informatics.s59160624.daydiary.database.Diary
import buu.informatics.s59160624.daydiary.database.DiaryDatabaseDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel for SleepTrackerFragment.
 */
class DiaryViewModel(
        val database: DiaryDatabaseDAO,
        application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()


    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val nights = database.getAll()

//    val nightsString = Transformations.map(nights) { nights ->
//        formatNights(nights, application.resources)
//    }

    private var today = MutableLiveData<Diary?>()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch {
            today.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): Diary? {

        return withContext(Dispatchers.IO) {

            var date = database.getDate()

            date
        }
    }

    fun onStartTracking() {
        uiScope.launch {
            val newDate = Diary()
            insert(newDate)
            today.value = getTonightFromDatabase()
        }
    }

    private suspend fun insert(date: Diary) {
        withContext(Dispatchers.IO) {
            database.insert(date)
        }
    }

//    fun onStopTracking() {
//        uiScope.launch {
//            val oldNight = today.value ?: return@launch
//            update(oldNight)
//        }
//    }

//    private suspend fun update(date: Diary) {
//        withContext(Dispatchers.IO) {
//            database.update(date)
//        }
//    }

//    fun onClear() {
//        uiScope.launch {
//            clear()
//            today.value = null
//        }
//    }

//    suspend fun clear() {
//        withContext(Dispatchers.IO) {
//            database.clear()
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

