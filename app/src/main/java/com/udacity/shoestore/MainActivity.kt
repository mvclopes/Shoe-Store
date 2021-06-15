package com.udacity.shoestore

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.view.login.LoginViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, _: Bundle?  ->
            if ( nd.id != nc.graph.startDestination && !viewModel.eventUserLogged.value!!){
                //TODO:Caso não esteja na tela inicial e usuário não logado
                nc.popBackStack()
                nc.navigate(nc.graph.startDestination)
            }
        }
    }

    override fun onNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
