//
//  RevenueMonsterBridge.m
//  RevenueMonster
//
//  Created by Jun Kai Gan on 23/07/2019.
//  Copyright © 2019 Facebook. All rights reserved.
//


#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(RevenueMonster, NSObject)

RCT_EXTERN_METHOD(addEvent:(NSString *)name location:(NSString *)location date:(nonnull NSNumber *)date)

@end
