#!/bin/sh
rm -rf example
mkdir example

for i in Order User Buyer Admin Seller City Item Category OrderReview BuyerFavoriteItem Comment Message Conversation FromAdminMessage ToAdminMessage ItemReport SellerReport BuyerSellerLike; do
	templater ../src/views/___component___Detail.vue example/${i}Detail.vue $i.json 
done
