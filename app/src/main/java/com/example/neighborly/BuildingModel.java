package com.example.neighborly;

import java.util.ArrayList;
import java.util.List;

class BuildingModel {

    private String address;
    private List<UserModelFacade> usersList;
    private List<ItemModel> itemsList;
    private List<RequestModel> requestList;

    public BuildingModel() {
        usersList = new ArrayList<>();
        itemsList = new ArrayList<>();
        requestList = new ArrayList<>();
    }

    public BuildingModel(String address, UserModelFacade user) {
        this.address = address;
        this.usersList = new ArrayList<>();
        this.itemsList = new ArrayList<>();
        this.requestList = new ArrayList<>();
        this.usersList.add(user);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserModelFacade> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<UserModelFacade> usersList) {
        this.usersList = usersList;
    }

    public List<ItemModel> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemModel> itemsList) {
        this.itemsList = itemsList;
    }

    public void addItemToList(ItemModel item) {
        itemsList.add(item);
    }

    public void addUserToList(UserModelFacade user) {
        for (UserModelFacade oldUser: usersList){
            if (oldUser != null && oldUser.getId().equals(user.getId())){
                return;
            }
        }
        usersList.add(user);
    }

    public List<RequestModel> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<RequestModel> requestList) {
        this.requestList = requestList;
    }

    public void addRequestToList(RequestModel requestModel) {
        requestList.add(requestModel);
    }

    public RequestModel getLastRequest(){
        for(int i=requestList.size()-1; i>0; i-- ){
            if(requestList.get(i) != null){
                return requestList.get(i);
            }
        }
        return null;
    }

    public UserModelFacade getUserById(String id){
        for (UserModelFacade user: usersList){
            if (user!= null && user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public RequestModel getRequestById(String requestId) {
        for (RequestModel request: requestList){
            if (request != null && request.getRequestId().equals(requestId)){
                return request;
            }
        }
        return null;
    }

    public void setIsResolvedByRequestId(String requestId, boolean isResolved){
        for (int i = 0; i < requestList.size(); i++){
            RequestModel curRequest = requestList.get(i);
            if (curRequest != null && curRequest.getRequestId().equals(requestId)){
                curRequest.setResolved(isResolved);
                requestList.set(i, curRequest);
            }
        }
    }

    public void setUserDescriptionById(String userId, String newDesc) {
        for (int i = 0; i < usersList.size(); i++){
            UserModelFacade curNeighbor = usersList.get(i);
            if (curNeighbor != null && curNeighbor.getId().equals(userId)){
                curNeighbor.setDescription(newDesc);
                usersList.set(i, curNeighbor);
            }
        }

    }

    public void addBadgeToUserById(String userId, int chosenBadge) {
        for (int i = 0; i < usersList.size(); i++){
            UserModelFacade curNeighbor = usersList.get(i);
            if (curNeighbor != null && curNeighbor.getId().equals(userId)){
                curNeighbor.addBadge(chosenBadge);
                usersList.set(i, curNeighbor);
            }
        }
    }
}

