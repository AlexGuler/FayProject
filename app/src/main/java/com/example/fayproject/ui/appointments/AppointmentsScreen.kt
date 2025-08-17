package com.example.fayproject.ui.appointments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fayproject.R
import com.example.fayproject.models.ObservableData
import com.example.fayproject.ui.shared.FayErrorUi
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentsScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    val viewModel: AppointmentsViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier
            .padding(padding)
            .consumeWindowInsets(padding)
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            AppointmentsTopBar(
                onNewClicked = viewModel::onNewAppointment
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val tabs = listOf(
                stringResource(R.string.upcoming),
                stringResource(R.string.past)
            )
            val pagerState = rememberPagerState(pageCount = { tabs.size })
            val coroutineScope = rememberCoroutineScope()

            TabRow(
                selectedTabIndex = pagerState.currentPage,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary,
                indicator = { positions ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(positions[pagerState.currentPage]),
                        color = MaterialTheme.colorScheme.primary,
                        height = 1.dp
                    )
                },
                divider = {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.scrim
                    )
                }
            ) {
                tabs.forEachIndexed { index, label ->
                    val selected = pagerState.currentPage == index
                    Tab(
                        selected = selected,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = label,
                                color = if (selected) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.tertiary
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                }
            }

            PullToRefreshBox(
                isRefreshing = state.isLoading,
                onRefresh = viewModel::getAppointments
            ) {
                HorizontalPager(state = pagerState) { page ->
                    AppointmentsContainer(
                        observableList = if (page == 0) {
                            state.upcomingAppointments
                        } else {
                            state.pastAppointments
                        },
                        retry = viewModel::getAppointments,
                        onJoinAppointment = viewModel::onJoinAppointment
                    )
                }
            }
        }
    }
}

@Composable
private fun AppointmentsContainer(
    observableList: ObservableData<List<AppointmentUiItem>>,
    modifier: Modifier = Modifier,
    retry: () -> Unit,
    onJoinAppointment: (AppointmentUiItem) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when (observableList) {
            is ObservableData.Data<List<AppointmentUiItem>> -> {
                AppointmentsList(
                    appointments = observableList.data,
                    onJoinAppointment = onJoinAppointment
                )
            }
            is ObservableData.Error -> {
                FayErrorUi(
                    modifier = Modifier.align(Alignment.Center),
                    onRetry = retry
                )
            }
            ObservableData.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
