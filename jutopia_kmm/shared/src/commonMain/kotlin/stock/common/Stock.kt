package stock.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import stock.stocktrade.TradeType

@Serializable
data class Stock(
    val id: String,
    val stockCode: String,
    val stockName: String,
    val nowMoney: Int = 1000,
    val prevMoney: Int = 1000,
    val changeRate: Double = 0.0,
    val isOwnedByUser: Boolean = false,
    val changeMoney: Int = 0,
    val type: Int = 0, // 1증가 -1감소 0 그대로
)

@Serializable
data class StockListResponse(
    val result: ApiResult,
    val body: List<Stock>?
)

@Serializable
data class StockResponse(
    val result: ApiResult,
    val body: Stock?
)


@Serializable
data class ApiResult(
    val resultCode: Int,
    val resultMessage: String,
    val resultDescription: String
)

@Serializable
data class StockRequest(
    val memberId: String,
    val stockId: String,
    val type: TradeType, //BUY, SELL
    val volume: Long,
    val price: Int,
)

@Serializable
data class StockTradeResponse(
    val result: ApiResult,
    val body: Trade?
)

@Serializable
data class Trade(
    val id: String,
    val stockName: String,
    val stockCode: String,
    val memberId: String,
    val type: TradeType,
    val volume: Int,
    val price: Int,
    val totalPrice: Int,
    val tradeAt: Time? = Time()
)

@Serializable
data class Time(
    val hour: Int = 0,
    val minute: Int = 0,
    val second: Int = 0,
    val nano: Int = 0
)

@Serializable
data class MyStock(
    val id: String,
    val stockId: String,
    val stockName: String,
    val stockCode: String,
    val qty: Int,
    val totalPrice: Double,
    val avgPrice: Double
)

@Serializable
data class MyStocksResponse(
    val result: ApiResult,
    val body: List<MyStock>
)

@Serializable
data class MyStockResponse(
    val result: ApiResult,
    val body: MyStock
)
