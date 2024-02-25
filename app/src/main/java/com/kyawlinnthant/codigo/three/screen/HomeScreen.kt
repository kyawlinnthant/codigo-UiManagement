package com.kyawlinnthant.codigo.three.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kyawlinnthant.codigo.three.R
import com.kyawlinnthant.codigo.three.theme.CodigoThreeTheme
import com.kyawlinnthant.codigo.three.theme.dimen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(end = MaterialTheme.dimen.base2x)
                    .statusBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                    )
                }


                Image(
                    painter = painterResource(id = R.drawable.sea_aquarium),
                    contentDescription = null,
                    modifier = modifier
                        .size(MaterialTheme.dimen.base4x)
                        .weight(1f)

                )


                Box(
                    modifier = modifier
                        .clip(CircleShape)
                        .size(MaterialTheme.dimen.base3x)
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = null,
                        modifier = modifier.size(MaterialTheme.dimen.icon)
                    )
                }

            }

        },
        bottomBar = {

            BottomAppBar(
                containerColor = Color.Transparent
            ) {
                bottomBarItems.forEach { item ->
                    NavigationBarItem(
                        label = {
                            Text(
                                text = stringResource(id = item.label),
                                maxLines = 1
                            )
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = item.icon),
                                contentDescription = null,
                                modifier = modifier.size(MaterialTheme.dimen.icon)
                            )
                        },
                        selected = false,
                        onClick = {

                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Transparent,
                        ),

                        )
                }
            }
        }
    ) {
        HomeContent(paddingValues = it)
    }
}

@Preview(
    showSystemUi = true
)
@Composable
private fun HomeScreenPreview(){
    CodigoThreeTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
    ) {
        
        // todo :horizontal view pager
        item {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
        }

        item {
            Spacer(modifier = modifier.height(MaterialTheme.dimen.base2x))
        }

        item {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.dimen.base2x),
                contentAlignment = Alignment.Center
            ) {

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.base3x),
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.base2x),
                    modifier = modifier.wrapContentWidth()

                ) {
                    tabItems.forEach { item ->
                        Column(
                            modifier = modifier.width(intrinsicSize = IntrinsicSize.Max),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = modifier
                                    .width(intrinsicSize = IntrinsicSize.Max)
                                    .size(MaterialTheme.dimen.base4x)
                                    .clip(CircleShape)
                                    .background(
                                        color = MaterialTheme.colorScheme.onSurface.copy(
                                            0.1f
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null,
                                    modifier = modifier.size(MaterialTheme.dimen.base2x)
                                )
                            }
                            Spacer(modifier = modifier.height(MaterialTheme.dimen.small))
                            Text(
                                text = stringResource(id = item.label),
                                style = MaterialTheme.typography.labelMedium
                            )
                        }

                    }
                }
            }
        }

        item {
            Spacer(modifier = modifier.height(MaterialTheme.dimen.base2x))
        }

        item {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.dimen.base2x),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = modifier.weight(1f),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = MaterialTheme.dimen.base,
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,

                        ),

                    ) {

                    Column(modifier = modifier.padding(MaterialTheme.dimen.base2x)) {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = card1.title),
                                style = MaterialTheme.typography.titleSmall
                            )
                            Image(
                                painter = painterResource(id = card1.icon),
                                contentDescription = null,
                                modifier = modifier.size(MaterialTheme.dimen.icon)
                            )
                        }
                        Text(
                            text = stringResource(id = card1.desc),
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(
                                    alpha = 0.5f
                                )
                            )
                        )
                        Text(
                            text = stringResource(id = card1.label),
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.error
                            )
                        )
                    }

                }
                Spacer(modifier = modifier.width(MaterialTheme.dimen.base2x))
                Card(
                    modifier = modifier.weight(1f),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = MaterialTheme.dimen.base,
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {

                    Column(modifier = modifier.padding(MaterialTheme.dimen.base2x)) {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = card2.title),
                                style = MaterialTheme.typography.titleSmall
                            )
                            Image(
                                painter = painterResource(id = card2.icon),
                                contentDescription = null,
                                modifier = modifier.size(MaterialTheme.dimen.icon)
                            )
                        }
                        Text(
                            text = stringResource(id = card2.desc),
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = stringResource(id = card2.label),
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.error
                            )
                        )
                    }

                }
            }
        }

        item {
            Spacer(modifier = modifier.height(MaterialTheme.dimen.base2x))
        }
        item {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.dimen.base2x),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.upcoming),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = R.string.view_all),
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.error
                    )
                )
            }
        }
        item {
            Spacer(modifier = modifier.height(MaterialTheme.dimen.base2x))
        }

        // todo :horizontal view pager
        item {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 7f)
            )
        }
        item {
            Spacer(modifier = modifier.height(MaterialTheme.dimen.base2x))
        }
    }
}

data class TabItem(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,
)

private val tabItems = listOf(
    TabItem(
        icon = R.drawable.map,
        label = R.string.tab_map
    ),
    TabItem(
        icon = R.drawable.inhabitants,
        label = R.string.tab_inhabitants
    ),
    TabItem(
        icon = R.drawable.shows,
        label = R.string.tab_shows
    ),
    TabItem(
        icon = R.drawable.shopping,
        label = R.string.tab_shopping
    ),
    TabItem(
        icon = R.drawable.dine,
        label = R.string.tab_dine
    ),
    TabItem(
        icon = R.drawable.meet_n_greet,
        label = R.string.tab_meet_n_greet
    ),
)

data class BottomBarItem(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,
)

private val bottomBarItems = listOf(
    BottomBarItem(
        icon = R.drawable.btn_home,
        label = R.string.btn_home
    ),
    BottomBarItem(
        icon = R.drawable.btn_more,
        label = R.string.btn_wallet
    ),
    BottomBarItem(
        icon = R.drawable.btn_more,
        label = R.string.btn_more
    )
)

data class CardItem(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val desc: Int,
    @StringRes val label: Int,
)

private val card1 =
    CardItem(
        icon = R.drawable.my_e_tickets,
        title = R.string.card1_title,
        desc = R.string.card1_desc,
        label = R.string.card1_label
    )

private val card2 =
    CardItem(
        icon = R.drawable.park_hour,
        title = R.string.card2_title,
        desc = R.string.card2_desc,
        label = R.string.card2_label

    )