package com.example.tms_android_project.ui.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.tms_android_project.R
import com.example.tms_android_project.databinding.LoginFragmentBinding
import com.example.tms_android_project.databinding.TestFragmentBinding
import com.example.tms_android_project.ui.presentation.view_models.NewsViewModel
import com.example.tms_android_project.ui.presentation.view_models.TestViewModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Integer.sum

class TestFragment : Fragment() {

    private lateinit var binding: TestFragmentBinding

    private val viewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TestFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        workWithMultithreading()
    }

    private fun workWithMultithreading() {
        //Coroutines
        workWithCoroutines()
    }




    private fun workWithCoroutines() =
        viewModel.viewModelScope.launch {
            Log.d("TEST_ANDROID", "Start work with downloading file")
            downloadTwoFiles()
            Log.d("TEST_ANDROID", "All uploaded!")
        }

    private suspend fun downloadTwoFiles() = withContext(IO) {
        coroutineScope {
            //запуск нескольких корутин
//            launch { downloadFirstFile() }
//            launch { downloadSecondFile() }
            canselOrJoin()
        }
    }

    private suspend fun downloadFirstFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download first file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... first file download finished ! .....")
    }

    private suspend fun downloadSecondFile() = withContext(IO) {
        Log.d("TEST_ANDROID", ".... starting download second file.....")
        delay(3_000)
        Log.d("TEST_ANDROID", ".... second file download finished ! .....")
    }


    //Отложенный запуск коррутины (lazy) -> start()
    private fun testStart() =
        viewModel.viewModelScope.launch {
            val job = launch(start = CoroutineStart.LAZY) {
                delay(200L)
                Log.d("TEST_ANDROID", "Coroutine has started")
            }

            delay(1000L)
            job.start() // запускаем корутину
            Log.d("TEST_ANDROID", "Other actions in main method")
        }




    /**
    Функция runBlocking блокирует вызывающий поток, пока все корутины внутри вызова
    runBlocking { ... } не завершат свое выполнение.
    В этом собственно основное отличие runBlocking от coroutineScope:
    coroutineScope не блокирует вызывающий поток, а просто приостанавливает выполнение,
    освобождания поток для использования другими ресурсами.
     **/
//    private fun testRunBlocking() = runBlocking {
//        launch { downloadFirstFile() }
//        launch { downloadSecondFile() }




    /**
     *  Job
     *
     *
     */
//Построитель корутин launch возвращает Job, с помощью которого можно управлять корутиной

    suspend fun canselOrJoin() = coroutineScope {

        val downloader: Job = launch {
            Log.d("TEST_ANDROID", "Загружаем файлы....")
            for (i in 1..100) {
                Log.d("TEST_ANDROID", "Файл $i загружен!")
                delay(1000L)
            }
        }

        delay(500L)
        Log.d("TEST_ANDROID", "Прервем загрузку? ")

        downloader.cancel()    // отменяем корутину
        downloader.join()      // ожидаем завершения корутины
        //   downloader.cancelAndJoin()    // отменяем корутину и ожидаем ее завершения
    }






    //async - построитель как и launch
    /** async-корутина возвращает объект Deferred, который ожидает получения результата корутины.
     *   (Интерфейс Deferred унаследован от интерфейса Job, поэтому для также доступны весь функционал,
     *    определенный для интефейса Job)
     **/
    suspend fun testAsync() = coroutineScope {
        async { downloadFirstFile() }
        Log.d("TEST_ANDROID", "Download file success")
    }

    suspend fun testAsyncWithAwait() = coroutineScope {

        val downloadFirstFile = async { sum(1, 2) }
        val downloadSecondFile = async { sum(5, 6) }

        val result1 = downloadFirstFile.await()
        val result2 = downloadSecondFile.await()

        Log.d("TEST_ANDROID", "result1: $result1  result2: $result2")
    }


    //Dispatcher
    /**
     *  Диспетчер корутины определяет какой поток или какие потоки будут
     *  использоваться для выполнения корутины (это важно!)
     *
     *  Все построители корутины, в частности, функции launch и async в качестве
     *  необязательного параметра принимают объект типа CoroutineContext,
     *  который может использоваться для определения диспетчера создаваемой корутины.
     *
     *  Dispatcher.Default - по умолчанию
     *
     *  Dispatchers.Default:
     *  применяется по умолчанию, если тип диспетчера не указан явным образом.
     *  Этот тип использует общий пул разделяемых фоновых потоков и подходит
     *  для вычислений, которые не работают с операциями ввода-вывода
     *  и которые требуют интенсивного потребление ресурсов центрального процессора.
     *
     *  Dispatchers.IO:
     *  использует общий пул потоков, создаваемых по мере необходимости,
     *  и предназначен для выполнения операций ввода-вывода (запросы)
     *
     *  Dispatchers.Main:
     *  применяется в графических приложениях, например, в приложениях Android или JavaFX.
     *
     *  Dispatchers.Unconfined:
     *  корутина не закреплена четко за определенным потоком или пулом потоков.
     *  Она запускается в текущем потоке до первой приостановки.
     *  После возобновления работы корутина продолжает работу в одном из потоков,
     *  который сторого не фиксирован.
     *  НЕ РЕКОМЕНДУЕТСЯ
     */
    suspend fun testDispatcher() = coroutineScope {
        launch(context = Dispatchers.Default) {
            downloadFirstFile()
        }
    }

    //channels
    /**
     * Каналы позволяют передавать потоки данных.
     * В Kotlin каналы представлены интерфейсом Channel,
     * у которого следует выделить два основных метода:
     *
     * abstract suspend fun send(element: E): Unit - Отправляет объект element в канал
     * abstract suspend fun receive(): E - Получает данные из канала
     */

    suspend fun еуыеСрфттуды() = coroutineScope {
        val channel = Channel<Int>()
        launch {
            for (n in 1..10) {
                // отправляем данные через канал
                channel.send(n)
            }
        }

        // получаем данные из канала
        repeat(10) {
            val number = channel.receive()
            println(number)
        }
        Log.d("TEST_ANDROID", "End")
    }
}