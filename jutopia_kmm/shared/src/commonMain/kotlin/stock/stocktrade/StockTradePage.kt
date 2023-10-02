package stock.stocktrade

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import stock.common.StockRow
import stock.common.StockViewModel
import stock.stocklist.StockListViewModel


@Composable
fun StockTradePage(
    stockId: String,
    stockViewModel: StockViewModel,
    viewModel: StockTradeViewModel = moe.tlaster.precompose.viewmodel.viewModel(modelClass = StockTradeViewModel::class) {
        StockTradeViewModel(stockId = stockId)
    },
    navigator: Navigator,
    modifier: Modifier = Modifier
) {
    val stock by stockViewModel.currentStock.collectAsState()

    val tradeType by viewModel.tradeType.collectAsState()

    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(
            onClick = { viewModel.changeTradeType(TradeType.BUY) },
            modifier = Modifier.weight(1f)
        ) {
            Text("구매")
        }
        Button(
            onClick = { viewModel.changeTradeType(TradeType.SELL) },
            modifier = Modifier.weight(1f)
        ) {
            Text("판매")
        }
        Button(
            onClick = { viewModel.changeTradeType(TradeType.Pending) },
            modifier = Modifier.weight(1f)
        ) {
            Text("미체결")
        }

    }
    when (tradeType) {
        TradeType.BUY -> {
            StockBuyingPage(stock!!)
        }

        TradeType.SELL -> {
            StockSellingPage(stock!!)
        }

        TradeType.Pending -> {
            StockPendingPage(stock!!)
        }
    }
}

