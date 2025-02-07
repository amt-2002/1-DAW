local personalInfo = {
    cooldownActive = false, 
}

CreateThread(function()
    for k, prop in pairs(Config.Props) do
        
        local propHash = joaat(prop) 
        local success = lib.requestModel(propHash)
        if not success then 
            print("Failed to load prop: " .. prop)
            return 
        end 

        exports.ox_target:addModel(propHash. {
            {
                label = "Buscar en la papelera", 
                icon = "fas fa-trash",
                distance = 2.5,
                onSelect = function(data)

                    if personalInfo.cooldownActive then 
                        QBCore.Functions.Notify("Relaja, que estas dejando todo vacio!", "error") 
                        return 
                    end

                    local canAccess = lib.callback.await('wond_basura:server:CheckCooldownProp', false, NetworkGetNetworkIdFromEntity(data.entity)) 

                    if not canAccess then
                        QBCore.Functions.Notify("Parece que en la papelera no hay nada", "error") 
                        return 
                    end

                    if lib.progressCircle({
                        duration = Config.TimeToSearch * 1000,
                        position = 'bottom',
                        label = 'Buscando en la basura',
                        useWhileDead = false,
                        canCancel = true,
                        disable = {
                            move = true, 
                            combat = true, 
                        },
                        anim = {
                            dict = 'anim@amb@business@trash@trash_picking@',
                            clip = 'trash_picking',
                        },
                    }) then 
                        personalInfo.cooldownActive = true 
                        TriggerServerEvent("wond_basura:server:searchProp", NetworkGetNetworkIdFromEntity(data.entity))
                        SetTimeout(Config.Cooldown * 1000, function()
                            personalInfo.cooldownActive = false 
                        end) 
                    end
                end  
            }
        })
    end 
end)

