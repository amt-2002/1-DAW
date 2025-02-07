local PropsCooldown = {} 

RegisterNetEvent("wond_basura:server:searchProp", function(entityNetId)
    local src = source
    local entityProp = NetworkGetEntityFromNetworkId(entityNetId) 
    local itemsReward = {}
    if not DoesEntityExist(entityProp) then 
        return 
    end

    for k, v in pairs(Config.ItemsReward) do 
        local chance = math.random(1, 100) 
        if chance <= v.chance then 
            local item = v.item 
            local count = v.count 
            itemsReward[#itemsReward + 1] = {item, count}
        end
    end

    local propStash = exports.ox_inventory:CreateTemporaryStash({
        label = "Basura " .. entityNetId,
        slots = #itemsReward,
        maxWeight = 50000,
        items = itemsReward,
    })
     
    TriggerClientEvent('ox_inventory:openInventory', src, 'stash', propStash)

    PropsCooldown[entityProp] = true

    SetTimeout(Config.RefillTime * 1000, function()
        PropsCooldown[entityNetId] = false
    end)
end)

lib.callback.register('wond_basura:server:CheckCooldownProp', function(source, entityNetId)
    local entityProp = NetworkGetEntityFromNetworkId(entityNetId)

    if not DoesEntityExist(entityProp) then 
        return false 
    end

    return PropsCooldown[entityProp] or false 
end)