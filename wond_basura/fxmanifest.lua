fx_version 'cerulean'
game 'gta5'

name "wond_basura"
description "Sistema de busqueda de basura en contenedores"
author "pelucasesp"
version "1.0.0"
lua54 'yes' 

shared_scripts {
	'shared/*.lua',
	'@ox_lib/init.lua'
}

client_scripts {
	'client/*.lua'
}

server_scripts {
	'server/*.lua'
}
