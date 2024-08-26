package com.example.challenge

import com.example.challenge.domain.model.Product
import com.example.challenge.domain.model.ProductList
import com.example.challenge.domain.usecases.GetProducts
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub


class PrimaryViewModelTest: BaseTest() {
    private var getProducts = mock<GetProducts>()
    private lateinit var viewModel: PrimaryViewModel

    @Before
    override fun setup(){
        super.setup()
        viewModel = PrimaryViewModel(usecase = getProducts)
    }

    @Test
    fun `test viewModel initialization values before loadInitialData`() {
        assert(!viewModel.uiState.value.failedInLoading)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test success response once loadInitialData is called`() = runTest {
        getProducts.stub {
            onBlocking {
                invoke()
            } doReturn ProductList(items = listOf(Product(name = "1.name", tagline = "1.tag", date = "01-01-2024", rating = 4.26)))
        }
        viewModel.loadInitialData()
        advanceUntilIdle()
        assert(viewModel.uiState.value.products.items.count() == 1)
        assert(viewModel.uiState.value.products.items.first().name == "1.name")
        assert(viewModel.uiState.value.products.items.first().tagline == "1.tag")
        assert(viewModel.uiState.value.products.items.first().date == "01-01-2024")
        assert(viewModel.uiState.value.products.items.first().rating == 4.26)
    }
}